package jerryofouc.github.io;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by xiaojiez on 5/21/17.
 */
public class LongestHarmoniousSubsequence {
    public static int findLHS(int[] nums) {
        Map<Integer,Integer> map = new TreeMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        Integer last = null;
        Integer lastSize = 0;

        int max = 0;

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(last != null && (entry.getKey()-last)==1){
                max = Math.max(lastSize+entry.getValue(),max);
            }
            last = entry.getKey();
            lastSize = entry.getValue();

        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,2,5,2,3,7};
        System.out.println(findLHS(nums));
    }
}
