package jerryofouc.github.io;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 4/7/14
 * Time: 10:10
 * To change this template use File | Settings | File Templates.
 */
public class UniqueBinarySearchTreesII {
    public ArrayList<TreeNode> generateTrees(int n) {
        int[] array = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            array[i] = i;
        }
        return generateTrees(array, 1, n);
    }

    private ArrayList<TreeNode> generateTrees(int[] array, int begin, int end) {
        ArrayList<TreeNode> returnValue = new ArrayList<TreeNode>();
        if (begin <= end) {
            for (int i = begin; i <= end; i++) {
                ArrayList<TreeNode> left = generateTrees(array, begin, i - 1);
                ArrayList<TreeNode> right = generateTrees(array, i + 1, end);
                for (TreeNode l : left) {
                    for (TreeNode r : right) {
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        root.right = r;
                        returnValue.add(root);
                    }
                }
            }
        } else {
            returnValue = new ArrayList<TreeNode>();
            returnValue.add(null);
        }
        return returnValue;
    }
}
