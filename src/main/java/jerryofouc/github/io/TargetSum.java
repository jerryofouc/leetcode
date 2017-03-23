package jerryofouc.github.io;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaojiez on 3/22/17.
 */
public class TargetSum {
    public static int findTargetSumWays(int[] nums, int S) {
        Map<Integer,Integer> sum = new HashMap<>();
        sum.put(nums[0],1);
        if(nums[0] == 0){
            sum.put(nums[0],2);
        }else {
            sum.put(-nums[0],1);
        }
        for(int i=1;i<nums.length;i++){
            Map<Integer,Integer> newSum = new HashMap<>();
            for(Map.Entry<Integer,Integer> entry : sum.entrySet()){
                int first = entry.getKey()+nums[i];
                int c = newSum.getOrDefault(first,0);
                newSum.put(first,c+entry.getValue());
                int second = entry.getKey()-nums[i];
                 c = newSum.getOrDefault(second,0);
                newSum.put(second,c+entry.getValue());
            }
            sum = newSum;
        }
        return sum.getOrDefault(S,0);
    }

    public static void main(String[] args) {
        int[] num = {33,36,38,40,25,49,1,8,50,13,41,50,29,27,18,25,37,8,0,48};
        long t1 = System.currentTimeMillis();
        System.out.println(findTargetSumWays(num,0));
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
    }
}
