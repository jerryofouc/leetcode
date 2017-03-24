package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xiaojiez on 3/24/17.
 */
public class FindLargestValueinEachTreeRow {
    static class Pair{
        public Pair(TreeNode treeNode, int level) {
            this.treeNode = treeNode;
            this.level = level;
        }

        TreeNode treeNode;
        int level;
    }
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root,0));
        int level = -1;
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()){
            Pair pair = queue.poll();
            if(pair.level != level){
                if(level != -1){
                    result.add(max);
                }
                level++;
                max = pair.treeNode.val;
            }else {
                max = Math.max(max,pair.treeNode.val);
            }
            if(pair.treeNode.left != null){
                queue.add(new Pair(pair.treeNode.left,pair.level+1));
            }
            if(pair.treeNode.right != null){
                queue.add(new Pair(pair.treeNode.right,pair.level+1));
            }
        }
        result.add(max);
        return result;
    }
}
