package jerryofouc.github.io;

import java.util.*;

/**
 * Created by xiaojiezhang on 11/3/16.
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        if(nums.length<3){
            return new ArrayList<List<Integer>>();
        }
        int i = 0;
        while(i<nums.length-2){
            int j = i+1;
            int k = nums.length-1;
            while (j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    List<Integer> record = new ArrayList<Integer>();
                    record.add(nums[i]);
                    record.add(nums[j]);
                    record.add(nums[k]);
                    result.add(record);
                    while (k>j && nums[k] == nums[k-1]){
                        k--;
                    }
                    while(j<k&&nums[j+1]==nums[j]){
                        j++;
                    }
                    j++;
                    k--;
                }else if(sum>0){
                    while (k>j && nums[k] == nums[k-1]){
                        k--;
                    }
                    k=k-1;
                }else {
                    while(j<k&&nums[j+1]==nums[j]){
                        j++;
                    }
                    j++;
                }

            }
            while(i<nums.length-2&&nums[i+1]==nums[i]){
                i++;
            }
            i++;
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{
                1,-1,-1,0
        }));
    }
}
