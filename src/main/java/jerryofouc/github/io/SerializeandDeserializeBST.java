package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xiaojiez on 3/14/17.
 */
public class SerializeandDeserializeBST {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null){
            return "x";
        }
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node == null){
                list.add("x");
            }else {
                list.add(node.val+"");
                if(node.right != null){
                    stack.push(node.right);
                }else {
                    stack.push(null);
                }
                if(node.left != null){
                    stack.push(node.left);
                }else {
                    stack.push(null);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i=0;i<list.size();i++){
            if(i != list.size()-1){
                result.append(list.get(i)).append(",");
            }else {
                result.append(list.get(i));
            }
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Stack<TreeNode> stack = new Stack<>();
        String[] a = data.split(",");
        List<String> list = new ArrayList<>();
        for(int i=0;i<a.length;i++){
            list.add(a[i]);
        }
        if(data.equals("x")){
            return null;
        }else {
            int i = 0;
            TreeNode ret = null;
            TreeNode root = new TreeNode(Integer.parseInt(list.get(i++)));
            ret = root;
            stack.push(root);
            while (!list.get(i).equals("x")){
                root.left =  new TreeNode(Integer.parseInt(list.get(i++)));
                stack.push(root.left);
                root = root.left;
            }
            i++;
            while ( i<list.size()){
                TreeNode treeNode = stack.pop();
                if(!list.get(i).equals("x")){
                    treeNode.right = new TreeNode(Integer.parseInt(list.get(i++)));
                    stack.push(treeNode.right);
                    root = treeNode.right;
                    while (!list.get(i).equals("x")){
                        root.left =  new TreeNode(Integer.parseInt(list.get(i++)));
                        stack.push(root.left);
                        root = root.left;
                    }
                    i++;
                }else {
                    i++;
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        SerializeandDeserializeBST serializeandDeserializeBST = new SerializeandDeserializeBST();
        System.out.println(serializeandDeserializeBST.serialize(serializeandDeserializeBST.deserialize("1,2,3,x,x,4,x,x,5,6,x,x,7,x,x")));
    }
}
