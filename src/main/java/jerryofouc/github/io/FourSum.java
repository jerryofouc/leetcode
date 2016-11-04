package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiaojiezhang on 11/4/16.
 */
public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length <4){
            return new ArrayList<List<Integer>>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i=nums.length-1;i>2;i--){
            List<List<Integer>> records = threeSum(nums,i-1,target-nums[i]);
            for(List<Integer> r : records){
                r.add(nums[i]);
                result.add(r);
            }
            while (i>2&&nums[i]==nums[i-1]){
                i--;
            }
        }
        return result;
    }

    private static List<List<Integer>>  threeSum(int[] nums, int end, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int i = 0;
        while (i<end-1){
            int j = i+1;
            int k = end;
            while (j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target){
                    List<Integer> record = new ArrayList<Integer>();
                    record.add(nums[i]);
                    record.add(nums[j]);
                    record.add(nums[k]);
                    result.add(record);
                    while (j<k && nums[j] == nums[j+1]){
                        j++;
                    }
                    j++;
                    while (j<k&&nums[k] == nums[k-1]){
                        k--;
                    }
                    k--;
                }else if(sum >target){
                    while (j<k&&nums[k] == nums[k-1]){
                        k--;
                    }
                    k--;
                }else if(sum < target){
                    while (j<k && nums[j] == nums[j+1]){
                        j++;
                    }
                    j++;
                }
            }
            while (i<end-2&&nums[i] == nums[i+1]){
                i++;
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,5,3,5,1,-5,1,-2};
        System.out.println(fourSum(nums,0));
    }
}
