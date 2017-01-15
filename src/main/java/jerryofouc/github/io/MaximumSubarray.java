package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/15/17.
 */
public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int currentMax = nums[0];
        int curSeqSum = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i]+curSeqSum){
                curSeqSum = nums[i];
            }else {
                curSeqSum = curSeqSum+nums[i];
            }
            if(curSeqSum>currentMax){
                currentMax = curSeqSum;
            }
        }
        return currentMax;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
