package jerryofouc.github.io;

import java.util.HashSet;

/**
 * Created by xiaojiez on 3/25/17.
 */
public class ContinuousSubarraySum {
    public static boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length<=1 ){
            return false;
        }

        for(int i=0;i+1<nums.length;i++){
            if(nums[i] == 0&&nums[i+1] == 0){
                return true;
            }
        }

        if(k == 0){
            return false;
        }

        k = Math.abs(k);
        for(int i=0;i<nums.length;i++){
            nums[i] = nums[i]%k;
        }

        HashSet<Integer> set = new HashSet<>();
        set.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(set.contains((k-nums[i])%k)){
                return true;
            }
            HashSet<Integer> toAdd = new HashSet<>();
            for(Integer a:set){
                toAdd.add((a+nums[i])%k);
            }
            toAdd.add(nums[i]);
            set = toAdd;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0};
        System.out.println(checkSubarraySum(nums,-1));
    }


}
