package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/26/17.
 */
public class DiameterofBinaryTree {
    static class Result{
        int max = 0;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        Result result = new Result();
        postOrder(root,result);
        return Math.max(0,result.max-1);
    }

    private int postOrder(TreeNode root, Result result) {
        if(root == null){
            return 0;
        }
        int leftMax = 0;
        if(root.left != null){
            leftMax = postOrder(root.left,result);
        }
        int rightMax = 0;
        if(root.right != null){
            rightMax = postOrder(root.right,result);
        }
        result.max = Integer.max(result.max,1+leftMax+rightMax);
        return Math.max(leftMax,rightMax)+1;
    }
}
