package jerryofouc.github.io;

import java.util.Arrays;

/**
 * Created by xiaojiez on 5/15/17.
 */
public class ShortestUnsortedContinuousSubarray {
    public static int findUnsortedSubarray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] copy = Arrays.copyOf(nums,nums.length);
        Arrays.sort(copy);
        int start = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == copy[i]){
                start++;
            }else {
                break;
            }
        }
        int end = 0;
        for(int j=nums.length-1;j>=start;j--){
            if(nums[j] == copy[j]){
                end++;
            }else {
                break;
            }
        }
        return (nums.length-start-end);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        System.out.println(findUnsortedSubarray(nums));
    }
}
