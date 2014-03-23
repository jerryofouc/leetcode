package jerryofouc.github.io;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 3/23/14
 * Time: 19:53
 * To change this template use File | Settings | File Templates.
 */
public class PathSumII {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();

    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        arrayLists.clear();
        ArrayList<Integer> parent = new ArrayList<Integer>();
        if(root == null){
            return arrayLists;
        }
        pathSum(root,parent,sum);
        return arrayLists;
    }

    private static void pathSum(TreeNode root, ArrayList<Integer> parent, int sum) {
        if(root == null){
            return;
        }else{
            parent.add(root.val);
            if(root.left == null && root.right == null){
                if(root.val == sum){
                    arrayLists.add(new ArrayList<Integer>(parent));
                }
            }else{
                pathSum(root.left,parent,sum-root.val);
                pathSum(root.right,parent,sum-root.val);
            }
            parent.remove(parent.size()-1);//remove last
        }
    }

    public static void main(String args[]){
        System.out.println(pathSum(new TreeNode(1),1));
    }
}
