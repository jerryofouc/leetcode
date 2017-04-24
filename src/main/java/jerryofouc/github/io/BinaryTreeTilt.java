package jerryofouc.github.io;

/**
 * Created by xiaojiez on 4/23/17.
 */
public class BinaryTreeTilt {
    private static class Pair{
        public Pair(int sum, int tilt) {
            this.sum = sum;
            this.tilt = tilt;
        }

        int sum;
        int tilt;
    }
    public static int findTilt(TreeNode root) {
        Pair pair = findTiltPair(root);
        return pair.tilt;
    }

    private static Pair findTiltPair(TreeNode root) {
        if(root == null){
            return new Pair(0,0);
        }
        Pair left = findTiltPair(root.left);
        Pair right = findTiltPair(root.right);

        Pair result = new Pair(left.sum+right.sum + root.val,left.tilt+right.tilt+Math.abs(left.sum-right.sum));
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        System.out.println(findTilt(root));

    }
}
