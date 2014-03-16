package jerryofouc.github.io;

import java.util.HashMap;

/**
 * User: zhangxiaojie
 * Date: 3/11/14
 * Time: 23:14
 * To change this template use File | Settings | File Templates.
 */
public class BinaryTreeMaximumPathSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    HashMap<TreeNode, Integer> treeNodeHashMap = new HashMap<TreeNode, Integer>();
    private int maxValue = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        treeNodeHashMap.clear();
        maxValue = Integer.MIN_VALUE;
        maxPath1(root);
        traverse(root);
        return maxValue;
    }

    private void traverse(TreeNode root) {
        if(root == null){
            return ;
        }
        int left = 0;
        if(root.left != null){
            left = treeNodeHashMap.get(root.left);
        }
        int right = 0;
        if(root.right != null){
            right = treeNodeHashMap.get(root.right);
        }
        int max = max(max(max(root.val,root.val+left),root.val+right),root.val+left+right);
        if(max > maxValue){
            maxValue= max;
        }
        traverse(root.left);
        traverse(root.right);
    }

    private int maxPath1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxPath1(root.left);
        int right = maxPath1(root.right);
        int retValue = max(max(root.val, root.val + left), root.val + right);
        treeNodeHashMap.put(root, retValue);
        return retValue;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }


}
