package jerryofouc.github.io;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 3/23/14
 * Time: 21:04
 * To change this template use File | Settings | File Templates.
 */
public class MinimumDepthBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return minDepth1(root);

        }
    }

    private int minDepth1(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 1;
        } else {
            int min = Integer.MAX_VALUE;
            if (root.left != null) {
                min = Math.min(min, minDepth1(root.left));
            }
            if (root.right != null) {
                min = Math.min(min,minDepth1(root.right));
            }
            return min+1;
        }
    }
}
