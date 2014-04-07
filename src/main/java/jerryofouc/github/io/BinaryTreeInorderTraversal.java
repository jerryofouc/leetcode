package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 4/7/14
 * Time: 10:32
 * To change this template use File | Settings | File Templates.
 */
public class BinaryTreeInorderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur!= null){
            if(cur != null ){
                stack.push(cur);
                cur = cur.left;
            }else{
                TreeNode node = stack.pop();
                ret.add(node.val);
                cur = node.right;
            }
        }
        return ret;
    }
}
