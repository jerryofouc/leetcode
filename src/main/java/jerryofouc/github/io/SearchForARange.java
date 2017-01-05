package jerryofouc.github.io;

/**
 * Created by xiaojiezhang on 1/5/17.
 * 解题思路:
 * 1.普通的二分搜索的变形
 * 2.不能找到一个然后左搜索,右搜索遍历,如果这样遍历的话最差可能达到O(n)的一个复杂度
 */
public class SearchForARange {
    public static int[] searchRange(int[] nums, int target) {
        return searchRange(nums,0,nums.length-1,target);
    }

    private static int[] searchRange(int[] nums, int start, int end, int target) {
        if(start>end){
            return new int[]{-1,-1};
        }
        if(target == nums[start] && target == nums[end]){
            return new int[]{start,end};
        }
        int middleIndex = (start+end)/2;
        int m = nums[middleIndex];
        if(m == target){
            int[] right = searchRange(nums,middleIndex+1,end,target);
            int[] left = searchRange(nums,start,middleIndex-1,target);
            int leftM = middleIndex;
            int rightM = middleIndex;
            if(left[0] != -1){
                leftM = left[0];
            }
            if(right[1] != -1){
                rightM = right[1];
            }
            return new int[]{leftM,rightM};
        }else {
            if(target<m){
                return searchRange(nums,start,middleIndex-1,target);
            }else {
                return searchRange(nums,middleIndex+1,end,target);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] result = searchRange(nums,8);
        System.out.println(result);
    }
}
