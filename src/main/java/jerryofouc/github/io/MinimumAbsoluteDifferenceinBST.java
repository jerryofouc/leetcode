package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaojiez on 3/25/17.
 */
public class MinimumAbsoluteDifferenceinBST {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        inOrder(root,l);
        int min = Integer.MAX_VALUE;
        for(int i=0;i+1<l.size();i++){
            min = Math.min(l.get(i+1)-l.get(i),min);
        }
        return min;
    }

    private void inOrder(TreeNode root, List<Integer> l) {
        if(root == null){
            return;
        }
        if(root.left != null){
            inOrder(root.left,l);
        }
        l.add(root.val);
        if(root.right != null){
            inOrder(root.right,l);
        }
    }
}
