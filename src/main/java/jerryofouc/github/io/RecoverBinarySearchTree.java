package jerryofouc.github.io;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 4/6/14
 * Time: 20:30
 * To change this template use File | Settings | File Templates.
 */
public class RecoverBinarySearchTree {
    public static void recoverTree(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        TreeNode last = null;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (last != null) {
                if (first == null && last.val > node.val) {//have not found first
                    first = last;
                }
                if (first != null && last.val > node.val) {
                    second = node;
                }
            }
            last = node;
            if (node.right != null) {
                cur = node.right;
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
            }
        }

        //swap
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public static void main(String args[]) {
        char[] tree = {'0', '1'};
        TreeNode root = Utils.deserializeTree(tree);
        recoverTree(root);
    }
}

