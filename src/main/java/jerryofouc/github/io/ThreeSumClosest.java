package jerryofouc.github.io;

import java.util.Arrays;

/**
 * Created by xiaojiezhang on 11/3/16.
 */
public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closedValue = Integer.MAX_VALUE;
        int i=0;
        while (i<nums.length-2){
            int j=i+1;
            int k = nums.length-1;
            while (j<k){
                int sum = nums[i] + nums[j] + nums[k]-target;
                if(Math.abs(closedValue) > Math.abs(sum)){
                    closedValue = sum;
                }
                if(sum == 0){
                    return target;
                }else if(sum<0){
                    while (j<k && nums[j]==nums[j+1]){
                        j++;
                    }
                    j++;
                }else {
                    while (j<k && nums[k] == nums[k-1]){
                        k--;
                    }
                    k--;
                }
            }
            while (i<nums.length-2 && nums[i]==nums[i+1]){
                i++;
            }
            i++;
        }
        return closedValue +target;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2};
        System.out.println(threeSumClosest(nums,1));
    }
}
