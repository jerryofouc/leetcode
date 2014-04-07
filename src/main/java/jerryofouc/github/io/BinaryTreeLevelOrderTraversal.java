package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 4/6/14
 * Time: 17:22
 * To change this template use File | Settings | File Templates.
 */
public class BinaryTreeLevelOrderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public class LevelNode{
        int level;
        TreeNode treeNode;

        public LevelNode(int level, TreeNode treeNode) {
            this.level = level;
            this.treeNode = treeNode;
        }
    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>>  arrayLists = new ArrayList<ArrayList<Integer>>();
        if(root == null){
            return arrayLists;
        }

        ArrayList<LinkedList<Integer>>  linkedListArrayList = new ArrayList<LinkedList<Integer>>();


        Queue<LevelNode> queue = new LinkedList<LevelNode>();
        queue.add(new LevelNode(0,root));

        while(!queue.isEmpty()){
            LevelNode temp = queue.poll();
            TreeNode treeNode = temp.treeNode;
            int level = temp.level;
            LinkedList<Integer> linkedList = null;
            if(level<linkedListArrayList.size()){
                linkedList = linkedListArrayList.get(level);
            }else{
                linkedList = new LinkedList<Integer>();
                linkedListArrayList.add(linkedList);
            }

            linkedList.add(treeNode.val);

            if(treeNode.left != null){
                queue.add(new LevelNode(level+1,treeNode.left));
            }
            if(treeNode.right != null){
                queue.add(new LevelNode(level+1,treeNode.right));
            }
        }

        for(LinkedList<Integer> linkedList : linkedListArrayList){
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            for(Integer i : linkedList){
                arrayList.add(i);
            }
            arrayLists.add(arrayList);
        }

        return arrayLists;
    }
}
