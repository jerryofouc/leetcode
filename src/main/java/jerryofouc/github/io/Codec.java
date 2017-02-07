package jerryofouc.github.io;

import java.util.*;

/**
 * Created by xiaojiez on 2/6/17.
 */
public class Codec {


    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            if(treeNode == null){
                list.add("X");
            }else {
                list.add(treeNode.val+"");
                stack.push(treeNode.right);
                stack.push(treeNode.left);
            }
        }

        return String.join(",",list);
    }



    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data == null || data.equals("")){
            return null;
        }
        String[] aa = data.split(",");
        Queue<String> queue = new LinkedList<>();
        for(String a : aa){
            queue.add(a);
        }

        return buildTree(queue);
    }

    private static TreeNode buildTree(Queue<String> queue) {
        String x = queue.poll();
        if(x.equals("X")){
            return null;
        }else {
            TreeNode cur = new TreeNode(Integer.parseInt(x));
            cur.left = buildTree(queue);
            cur.right = buildTree(queue);
            return cur;
        }
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);

        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode.right.left = treeNode3;
        treeNode.right.right = treeNode4;
        deserialize(serialize(treeNode));
    }


}
