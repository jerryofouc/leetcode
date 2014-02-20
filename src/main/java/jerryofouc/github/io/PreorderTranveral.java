package jerryofouc.github.io;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 2/21/14
 * Time: 0:11
 * To change this template use File | Settings | File Templates.
 */
public class PreorderTranveral {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        preorderTraversal(root,arrayList);
        return  arrayList;

    }

    private void preorderTraversal(TreeNode root, ArrayList<Integer> arrayList) {
        if(root != null){
            arrayList.add(root.val);
            preorderTraversal(root.left,arrayList);
            preorderTraversal(root.right,arrayList);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
