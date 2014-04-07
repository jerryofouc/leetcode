package jerryofouc.github.io;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 4/6/14
 * Time: 17:28
 * To change this template use File | Settings | File Templates.
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }else{
            if(p != null && q!=null){
                if(p.val == q.val){
                    return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
                }
            }
            return false;
        }
    }
}
