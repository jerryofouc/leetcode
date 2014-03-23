package jerryofouc.github.io;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 3/23/14
 * Time: 21:46
 * To change this template use File | Settings | File Templates.
 */
public class ConvertSortedArrayBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode sortedArrayToBST(int[] num) {
        return getBST(num,0,num.length-1);

    }

    private TreeNode getBST(int[] array, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            TreeNode root = new TreeNode(array[mid]);
            root.left = getBST(array, start, mid-1);
            root.right = getBST(array, mid+1, end);
            return root;
        } else {
            return null;
        }
    }
}
