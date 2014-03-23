package jerryofouc.github.io;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 3/18/14
 * Time: 22:07
 * To change this template use File | Settings | File Templates.
 */
public class PopulatingNextRightPointersinEachNode {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        if(root == null || root.left==null && root.right == null){
            return;
        }

        TreeLinkNode left = root.left;
        TreeLinkNode right = root.right;
        left.next = right;

        while(left.right != null&& right.left!=null){
            left.right.next = right.left;
            left = left.right;
            right = right.left;
        }

        connect(root.left);
        connect(root.right);
    }
}
