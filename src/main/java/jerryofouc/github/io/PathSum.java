package jerryofouc.github.io;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 3/23/14
 * Time: 17:30
 * To change this template use File | Settings | File Templates.
 */
public class PathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }else{
            return hasPathSum1(root,sum);
        }
    }

    public static boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if(root.left == null && root.right == null){
            if(root.val == sum){
                return true;
            }else {
                return false;
            }
        }
        return hasPathSum1(root.left,sum-root.val)||hasPathSum1(root.right, sum-root.val);
    }

    public static void main(String args[]){
        System.out.println(hasPathSum(null,0));
    }
}
