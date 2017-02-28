package jerryofouc.github.io;

import java.util.*;

/**
 * Created by xiaojiez on 2/28/17.
 */
public class CombinationSumIV {
    public static int combinationSum4(int[] nums, int target) {
        HashMap<Integer,Integer> mem = new HashMap<>();
        Arrays.sort(nums);
        for(int i=1;i<=target;i++){
            int count = 0;
            for(int j : nums){
                if(i-j==0){
                    count++;
                }else if(i-j>0){
                    Integer ll =  mem.get(i-j);
                    if(ll!=null){
                        count+=ll;
                    }
                }
            }
            mem.put(i,count);
        }
        return mem.get(target);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,50};

        System.out.println(combinationSum4(nums,200));
    }


}
