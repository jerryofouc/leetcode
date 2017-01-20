package jerryofouc.github.io;

import java.util.*;

/**
 * Created by xiaojiez on 1/20/17.
 */
public class BinaryTreeRightSideView {
    public static List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<Integer>();
        List<TreeNode> queue = new LinkedList<TreeNode>() ;
        queue.add(root);
        while (!queue.isEmpty()){
            List<TreeNode> tempQueue = new ArrayList<TreeNode>();
            for(int i=0;i<queue.size();i++){
                TreeNode treeNode = queue.get(i);
                if(i == queue.size()-1){
                    result.add(treeNode.val);
                }
                if(treeNode.left != null){
                    tempQueue.add(treeNode.left);
                }
                if(treeNode.right != null){
                    tempQueue.add(treeNode.right);
                }
            }
            queue = tempQueue;
        }
        return result;
    }
}
