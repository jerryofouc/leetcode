package jerryofouc.github.io;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 3/2/14
 * Time: 9:27
 * To change this template use File | Settings | File Templates.
 */
public class SumRootLeafNumbers {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static int total = 0;

    public static int sumNumbers(TreeNode root) {
        total = 0;
        sumNumbers(root,0);
        return total;
    }

    private static void sumNumbers(TreeNode root, int sum) {
        if(root != null){
            if(root.left == null && root.right==null){
                total += sum*10 + root.val;
                return;
            }else{
                sum = sum*10 + root.val;
                sumNumbers(root.left,sum);
                sumNumbers(root.right,sum);
            }
        }
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(1);
        root.left = left;
        System.out.println(sumNumbers(root));
    }



}
