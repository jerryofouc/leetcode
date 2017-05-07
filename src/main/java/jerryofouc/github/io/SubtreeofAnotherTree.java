package jerryofouc.github.io;

/**
 * Created by xiaojiez on 5/7/17.
 */
public class SubtreeofAnotherTree {
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null){
            return s == t;
        }
        return isEqual(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    public static boolean isEqual(TreeNode s, TreeNode t){
        if(s == null && t == null){
            return true;
        }
        if(s == null || t == null){
            return false;
        }
        if(s.val != t.val){
            return false;
        }
        return isEqual(s.left,t.left) && isEqual(s.right,t.right);
    }
}
