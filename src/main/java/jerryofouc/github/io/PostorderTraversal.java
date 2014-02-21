package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 2/21/14
 * Time: 0:07
 * To change this template use File | Settings | File Templates.
 */
public class PostorderTraversal {
    static class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) {
            return arrayList;
        } else {
            TreeNode last = null;
            TreeNode p = root;
            while(p != null){
                stack.push(p);
                p = p.left;
            }
            while(!stack.isEmpty()){
                 p = stack.pop();
                if(p.right == last || p.right == null){
                    arrayList.add(p.val);
                    last = p;
                }else{
                    stack.push(p);
                    p = p.right;
                    while(p != null){
                        stack.push(p);
                        p = p.left;
                    }
                }
            }
        }
        return arrayList;
    }


}
