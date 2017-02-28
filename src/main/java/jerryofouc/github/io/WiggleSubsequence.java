package jerryofouc.github.io;

import java.util.LinkedList;

/**
 * Created by xiaojiez on 2/28/17.
 */
public class WiggleSubsequence {
    public static int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        boolean high = true;
        LinkedList<Integer> array = new LinkedList<>();
        int i=1;
        while (i<nums.length&&nums[i] == nums[i-1]){
            i++;
        }
        if(i==nums.length){
            return 1;
        }
        array.add(nums[i-1]);
        array.add(nums[i]);
        if(nums[i]<nums[i-1]){
            high = false;
        }
        i++;
        for(;i<nums.length;i++){
            if(high){
                if(nums[i]<nums[i-1]){
                    array.add(nums[i]);
                    high = false;
                }else if(nums[i]>nums[i-1]){
                    array.removeLast();
                    array.add(nums[i]);
                }
            }else {
                if(nums[i]>nums[i-1]){
                    array.add(nums[i]);
                    high = true;
                }else if(nums[i]<nums[i-1]){
                    array.removeLast();
                    array.add(nums[i]);
                }
            }
        }
        return array.size();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,17,5,10,13,15,10,5,16,8};
        System.out.println(wiggleMaxLength(nums));
    }
}
