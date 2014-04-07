package jerryofouc.github.io;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 4/6/14
 * Time: 17:32
 * To change this template use File | Settings | File Templates.
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSameTree(root.left,root.right);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }else{
            if(p != null && q!=null){
                if(p.val == q.val){
                    return isSameTree(p.left,q.right)&&isSameTree(p.right,q.left);
                }
            }
            return false;
        }
    }
}
