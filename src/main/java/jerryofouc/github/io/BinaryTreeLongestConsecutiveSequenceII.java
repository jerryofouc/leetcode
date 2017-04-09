package jerryofouc.github.io;

import java.util.*;

/**
 * Created by xiaojiez on 4/9/17.
 */
public class BinaryTreeLongestConsecutiveSequenceII {
    public static int longestConsecutive(TreeNode root) {
        if(root == null){
            return 0;
        }
        Map<TreeNode,Set<TreeNode>> g = new HashMap<>();
        inOrder(root,g);
        int max = 0;
        for(TreeNode treeNode : g.keySet()){
            HashSet<TreeNode> path = new HashSet<>();
            max = Math.max(dfs(treeNode,g,path),max);
        }
        return max;
    }

    private static int dfs(TreeNode treeNode, Map<TreeNode, Set<TreeNode>> g,HashSet<TreeNode> path) {
        path.add(treeNode);
        int max = path.size();
        Set<TreeNode> neighbours = g.getOrDefault(treeNode,new HashSet<>());
        for(TreeNode n : neighbours){
            HashSet<TreeNode> temp = new HashSet<>();
            temp.addAll(path);
            if(!path.contains(n) && n.val==treeNode.val+1){
                max = Math.max(max,dfs(n,g,temp));
            }

        }
        return max;
    }


    private static void inOrder(TreeNode root, Map<TreeNode, Set<TreeNode>> g) {
        Set<TreeNode> rootSet = g.getOrDefault(root,new HashSet<>());
        g.put(root,rootSet);
        if(root.left != null){
            Set<TreeNode> leftSet = g.getOrDefault(root.left,new HashSet<>());
            g.put(root.left,leftSet);
            leftSet.add(root);
            rootSet.add(root.left);
            inOrder(root.left,g);
        }
        if(root.right != null){
            Set<TreeNode> rightSet = g.getOrDefault(root.right,new HashSet<>());
            g.put(root.right,rightSet);
            rightSet.add(root);
            rootSet.add(root.right);
            inOrder(root.right,g);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(longestConsecutive(root));
    }
}
