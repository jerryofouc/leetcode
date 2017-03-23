package jerryofouc.github.io;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaojiez on 3/23/17.
 */
public class FindModeinBinarySearchTree {
    public static int[] findMode(TreeNode root) {
        if(root == null){
            return new int[]{};
        }
        TreeNode stackHeader = root;
        while (root != null){
            TreeNode leftNode = root.left;
            if(stackHeader == root){
                root.left = null;
            }else {
                root.left = stackHeader;
                stackHeader = root;
            }
            root = leftNode;
        }
        Set<Integer> maxSet = new HashSet<>();
        int currentMax = Integer.MIN_VALUE;
        int currentLength = 0;
        Integer last = null;
        int cur;
        while (stackHeader != null){
            TreeNode node = stackHeader;
            cur = node.val;
            stackHeader = stackHeader.left;
            if(last == null || (last != null && last == cur)){
                currentLength++;
                if(currentMax<currentLength){
                    maxSet = new HashSet<>();
                    maxSet.add(cur);
                    currentMax = currentLength;
                }else if(currentMax == currentLength){
                    maxSet.add(cur);
                }
            }else {
                currentLength = 1;
                if(currentMax == currentLength){
                    maxSet.add(cur);
                }
            }
            last = node.val;
            if(node.right != null){
                node = node.right;
                while (node != null){
                    TreeNode leftNode = node.left;
                    node.left = stackHeader;
                    stackHeader = node;
                    node = leftNode;
                }
            }
        }

        int[] result = new int[maxSet.size()];
        int i=0;
        for(Integer m : maxSet){
            result[i++] = m;
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right =new TreeNode(2);
        System.out.println(findMode(root));
    }
}
