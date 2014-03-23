package jerryofouc.github.io;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 3/23/14
 * Time: 16:41
 * To change this template use File | Settings | File Templates.
 */
public class FlattenBinaryTreeLinkedList {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }else{
            flatten1(root,null);
        }

    }

    private void flatten1(TreeNode head,TreeNode tail) {
        if(head == null){
            return ;
        }

        if(head.left == null && head.right == null){
            head.right = tail;
            return;
        }

        TreeNode left = head.left;
        TreeNode right = head.right;
        if(left != null){
            head.right = left;
        }

        head.left = null;
        if(left != null){
            if(right != null){
                flatten1(left,right);
            }else{
                flatten1(left,tail);
            }
        }

        if(right != null){
            flatten1(right,tail);
        }

    }
}
