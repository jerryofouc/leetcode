package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaojiez on 2/11/17.
 */
public class CountOfSmallerNumbersAfterSelf {

    private static class TreeNode{
        int leftSum;
        int dup;
        int val;
        TreeNode left;
        TreeNode right;

    }
    public static List<Integer> countSmaller(int[] nums) {
        int[] result = new int[nums.length];
        TreeNode root = null;

        for(int i=nums.length-1;i>=0;i--){
            root = insertTreeNode(root,0,result,i,nums);
        }

        List<Integer> resultList = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            resultList.add(result[i]);
        }
        return resultList;

    }

    private static TreeNode insertTreeNode(TreeNode node, int preSum, int[] result, int i,int[] nums) {
        if(node == null){
            result[i] = preSum;
            TreeNode treeNode = new TreeNode();
            treeNode.val = nums[i];
            treeNode.dup=1;
            treeNode.leftSum = 0;
            return treeNode;
        }else if(nums[i]==node.val){
            result[i] = preSum+node.leftSum;
            node.dup++;
        }else if(nums[i] < node.val){
            node.left =  insertTreeNode(node.left,preSum,result,i,nums);
            node.leftSum++;
        }else {
            node.right = insertTreeNode(node.right,preSum + node.leftSum+node.dup,result,i,nums);
        }
        return node;
    }



    public static void main(String[] args) {
        int[] num = new int[]{26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
        System.out.println(countSmaller(num));
    }
}
