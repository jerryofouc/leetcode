package jerryofouc.github.io;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 3/23/14
 * Time: 21:14
 * To change this template use File | Settings | File Templates.
 */
public class BalancedBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Pair {
        long length;
        boolean isBalance;

        Pair(long length, boolean balance) {
            this.length = length;
            isBalance = balance;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return balance(root).isBalance;
    }

    Pair balance(TreeNode root) {
        if (root == null) {
            return new Pair(0, true);
        } else {
            Pair left = balance(root.left);
            Pair right = balance(root.right);
            if (left.isBalance && right.isBalance && Math.abs(left.length - right.length) < 2) {
                return new Pair(Math.max(left.length, right.length) + 1, true);
            }
            return new Pair(Math.max(left.length, right.length) + 1, false);
        }
    }

    public static void main(String args[]) {

    }
}
