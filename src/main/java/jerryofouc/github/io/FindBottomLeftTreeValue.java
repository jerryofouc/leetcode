package jerryofouc.github.io;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xiaojiez on 3/24/17.
 */
public class FindBottomLeftTreeValue {
    static class Pair{
        public Pair(TreeNode treeNode, int level) {
            this.treeNode = treeNode;
            this.level = level;
        }

        TreeNode treeNode;
        int level;
    }
    public int findBottomLeftValue(TreeNode root) {
        int level = -1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root,0));
        int result = -1;
        while (!queue.isEmpty()){
            Pair pair = queue.poll();
            if(pair.level != level){
                level++;
                result = pair.treeNode.val;
            }
            if(pair.treeNode.left != null){
                queue.add(new Pair(pair.treeNode.left,pair.level+1));
            }
            if(pair.treeNode.right != null){
                queue.add(new Pair(pair.treeNode.right,pair.level+1));
            }
        }
        return result;
    }
}
