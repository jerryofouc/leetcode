package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaojiez on 1/26/17.
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> a1 = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            a1.add(cur);
            if (p == cur) {
                break;
            } else if (p.val > cur.val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        List<TreeNode> a2 = new ArrayList<>();

        cur = root;
        while (cur != null) {
            a2.add(cur);
            if (q == cur) {
                break;
            } else if (q.val > cur.val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        TreeNode common = root;
        for (int i = 0; i < Math.min(a1.size(), a2.size()); i++) {
            if (a1.get(i) == a2.get(i)) {
                common = a1.get(i);
            } else {
                break;
            }
        }

        return common;

    }


}
