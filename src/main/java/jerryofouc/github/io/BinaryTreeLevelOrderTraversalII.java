package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 4/1/14
 * Time: 23:34
 * To change this template use File | Settings | File Templates.
 */
public class BinaryTreeLevelOrderTraversalII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class LevelNode{
        int level;
        TreeNode treeNode;

        public LevelNode(int level, TreeNode treeNode) {
            this.level = level;
            this.treeNode = treeNode;
        }
    }

    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null){
            return new ArrayList<ArrayList<Integer>>();
        }
        Queue<LevelNode> levelNodesQueue = new LinkedList<LevelNode>();
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();
        LevelNode levelNode = new LevelNode(0,root);
        levelNodesQueue.add(levelNode);
        while(!levelNodesQueue.isEmpty()){
            LevelNode temp = levelNodesQueue.poll();
            int level = temp.level;
            TreeNode treeNode = temp.treeNode;
            ArrayList<Integer> arrayList = null;
            if(level<arrayLists.size()){
                 arrayList = arrayLists.get(level);
            }else{
                arrayList = new ArrayList<Integer>();
                arrayLists.add(arrayList);
            }
            arrayList.add(treeNode.val);
            if(treeNode.left != null){
                levelNodesQueue.add(new LevelNode(level+1,treeNode.left));
            }
            if(treeNode.right != null){
                levelNodesQueue.add(new LevelNode(level+1,treeNode.right));
            }
        }
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        for(int i=arrayLists.size()-1;i>=0;i--){
            ret.add(arrayLists.get(i));
        }
        return ret;
    }
}
