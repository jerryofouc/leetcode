package jerryofouc.github.io;

/**
 * Created by xiaojiez on 2/1/17.
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        long sum = (nums.length)*(0+nums.length+1)/2;
        long targetSum = 0;
        for(int i=0;i<nums.length;i++){
            targetSum += nums[i];
        }

        return (int)(sum-targetSum);

    }
}
