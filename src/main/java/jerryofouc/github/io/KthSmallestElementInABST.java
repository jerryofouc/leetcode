package jerryofouc.github.io;

import java.util.Stack;

/**
 * Created by xiaojiez on 1/26/17.
 */
public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        if(root==null&&k==0){
            return 0;
        }
        TreeNode cur = root;
        while (cur!= null){
            stack.push(cur);
            cur = cur.left;
        }
        int count=0;
        while (!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            count++;
            if(count==k){
                return treeNode.val;
            }else {
                cur = treeNode.right;
                while (cur!=null){
                    stack.push(cur);
                    cur = cur.left;
                }
            }
        }
        return -1;
    }
}
