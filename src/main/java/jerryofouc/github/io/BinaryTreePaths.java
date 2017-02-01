package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaojiez on 1/30/17.
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        if(root ==null){
            return new ArrayList<>();
        }
        String result = "";
        List<String> resultList = new ArrayList<>();

        binaryTreePaths(root,result,resultList);
        return resultList;

    }

    private void binaryTreePaths(TreeNode root, String result,List<String> resultList) {
        if(!result.equals("")){
            result= result+"->" +root.val;
        }else {
            result= result+"" +root.val;
        }
        if(root.left == null && root.right == null){
            resultList.add(result);
        }else {
            if(root.left != null){
                binaryTreePaths(root.left,result,resultList);
            }
            if(root.right != null){
                binaryTreePaths(root.right,result,resultList);
            }
        }
    }
}
