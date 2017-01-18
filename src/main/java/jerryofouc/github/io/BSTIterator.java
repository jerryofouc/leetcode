package jerryofouc.github.io;

import java.util.LinkedList;

/**
 * Created by xiaojiez on 1/18/17.
 */
public class BSTIterator {
    LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

    public BSTIterator(TreeNode root) {
        while (root != null){
            stack.add(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if(!hasNext()){
            throw new IllegalArgumentException();
        }
        TreeNode treeNode = stack.removeLast();
        int ret = treeNode.val;
        if (treeNode.right != null){
            stack.add(treeNode.right);
            treeNode = treeNode.right;
            while (treeNode.left != null){
                stack.add(treeNode.left);
                treeNode = treeNode.left;
            }
        }
        return ret;
    }
}
