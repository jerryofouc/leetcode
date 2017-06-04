package jerryofouc.github.io;

/**
 * Created by xiaojiez on 6/4/17.
 */
public class ConstructStringfromBinaryTree {
    public String tree2str(TreeNode t) {
        if(t == null){
            return "";
        }
        String result = "";
        result+=t.val;
        if(t.right != null){
            result+="("+tree2str(t.left)+")"+"("+tree2str(t.right)+")";
        }else if(t.left != null){
            result+="("+tree2str(t.left)+")";
        }

        return result;
    }

}
