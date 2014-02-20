package jerryofouc.github.io;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 2/21/14
 * Time: 0:07
 * To change this template use File | Settings | File Templates.
 */
public class PostorderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        postorderTraversal(root,arrayList);
        return  arrayList;

    }

    private void postorderTraversal(TreeNode root, ArrayList<Integer> arrayList) {
        if(root != null){
            postorderTraversal(root.left,arrayList);
            postorderTraversal(root.right,arrayList);
            arrayList.add(root.val);
        }
    }

    static class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
    }

}
