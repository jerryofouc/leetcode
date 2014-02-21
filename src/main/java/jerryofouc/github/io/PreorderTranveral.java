package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 2/21/14
 * Time: 0:11
 * To change this template use File | Settings | File Templates.
 */
public class PreorderTranveral {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if(root == null) {
            return arrayList;
        }else{
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            while(!stack.isEmpty()){
                TreeNode p = stack.pop();
                while(p != null){
                    arrayList.add(p.val);
                    if(p.right != null){
                        stack.push(p.right);
                    }
                    p = p.left;
                }
            }
        }
        return arrayList;
    }

}
