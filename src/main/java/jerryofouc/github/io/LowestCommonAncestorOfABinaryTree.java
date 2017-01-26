package jerryofouc.github.io;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by xiaojiez on 1/26/17.
 */
public class LowestCommonAncestorOfABinaryTree {
    private TreeNodeParent pp;
    private TreeNodeParent qq;
    private static class TreeNodeParent{
        public TreeNodeParent(int val) {
            this.val = val;
        }

        int val;
        TreeNodeParent left;
        TreeNodeParent right;
        TreeNodeParent parent;
        TreeNode treeNode;
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNodeParent treeNodeParent = buildTreeNodeParent(root,p,q,null);
        LinkedList<TreeNodeParent> l1 = new LinkedList<>();
        while (pp != null){
            l1.addFirst(pp);
            pp = pp.parent;
        }
        LinkedList<TreeNodeParent> l2 = new LinkedList<>();
        while (qq != null){
            l2.addFirst(qq);
            qq = qq.parent;
        }

        TreeNode common = null;

        Iterator<TreeNodeParent> iterator1 = l1.iterator();
        Iterator<TreeNodeParent> iterator2 = l2.iterator();
        while (iterator1.hasNext() && iterator2.hasNext()){
            TreeNodeParent cur1 = iterator1.next();
            TreeNodeParent cur2 = iterator2.next();
            if(cur1 == cur2){
                common = cur1.treeNode;
            }else {
                break;
            }
        }

        return common;
    }

    private TreeNodeParent buildTreeNodeParent(TreeNode root, TreeNode p, TreeNode q,TreeNodeParent parent) {
        TreeNodeParent treeNodeParent = new TreeNodeParent(root.val);
        treeNodeParent.treeNode = root;
        treeNodeParent.parent = parent;
        if(p == root){
            pp = treeNodeParent;
        }
        if(q == root){
            qq = treeNodeParent;
        }
        TreeNodeParent left = null;
        if(root.left != null){
            left = buildTreeNodeParent(root.left,p,q,treeNodeParent);
        }
        TreeNodeParent right = null;

        if(root.right != null){
            right = buildTreeNodeParent(root.right,p,q,treeNodeParent);
        }

        treeNodeParent.left = left;
        treeNodeParent.right = right;
        return treeNodeParent;
    }
}
