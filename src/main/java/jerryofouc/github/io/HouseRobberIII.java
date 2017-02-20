package jerryofouc.github.io;

/**
 * Created by xiaojiez on 2/20/17.
 */
public class HouseRobberIII {
    public int rob(TreeNode root) {
        if(root == null){
            return 0;
        }

        int max1 = root.val;
        if(root.left != null){
            max1 = max1 +  rob(root.left.left) + rob(root.left.right);
        }
        if(root.right != null){
            max1 = max1 +  rob(root.right.left) + rob(root.right.right);
        }

        int max2 = rob(root.left) + rob(root.right);

        return Math.max(max1,max2);

    }
}
