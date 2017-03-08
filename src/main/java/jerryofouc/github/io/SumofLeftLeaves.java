package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaojiez on 3/8/17.
 */
public class SumofLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        List<Integer> sum = new ArrayList<>();
        sum.add(0);
        sumOfLeftLeaves(root,sum,false);
        return sum.get(0);
    }

    private void sumOfLeftLeaves(TreeNode root, List<Integer> sum, boolean isLeft) {
        if(root.left == null && root.right == null && isLeft){
            sum.set(0,sum.get(0)+root.val);
        }
        if(root.left != null){
            sumOfLeftLeaves(root.left,sum,true);
        }
        if(root.right != null){
            sumOfLeftLeaves(root.right,sum,false);
        }
    }
}
