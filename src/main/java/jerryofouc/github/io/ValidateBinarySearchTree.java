package jerryofouc.github.io;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 4/6/14
 * Time: 22:30
 * To change this template use File | Settings | File Templates.
 */
public class ValidateBinarySearchTree {
    public static boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode last = null;
        TreeNode cur = root;

        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode node = stack.pop();
                if(last == null){
                    last = node;
                }else {
                    if(last.val>=node.val){
                        return false;
                    }else{
                        last = node;
                    }
                }
                cur = node.right;
            }
        }
        return true;
    }

    public static void main(String args[]){
        char a[] = {'1','1'};
        TreeNode treeNode = Utils.deserializeTree(a);
        System.out.println(isValidBST(treeNode));
    }
}
