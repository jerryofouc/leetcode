package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaojiez on 3/25/17.
 */
public class ConvertBSTtoGreaterTree {
    public static TreeNode convertBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inOrder(root,list);
        int[] sum = new int[list.size()+1];
        sum[0] = 0;
        for(int i=1;i<sum.length;i++){
            sum[i] = list.get(i-1).val + sum[i-1];
        }
        for(int i=0;i<list.size();i++){
            TreeNode treeNode = list.get(i);
            treeNode.val += sum[sum.length-1] - sum[i+1];
        }
        return root;
    }

    private static void inOrder(TreeNode root, List<TreeNode> list) {
        if(root == null){
            return;
        }
        if(root.left != null){
            inOrder(root.left,list);
        }
        list.add(root);
        if(root.right != null){
            inOrder(root.right,list);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(-1);
        treeNode.left.left = new TreeNode(-3);
        treeNode.right = new TreeNode(2);
        treeNode.right.right = new TreeNode(4);
        System.out.println(convertBST(treeNode));
    }
}
