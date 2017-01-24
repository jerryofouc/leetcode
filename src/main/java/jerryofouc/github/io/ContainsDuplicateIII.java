package jerryofouc.github.io;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaojiez on 1/24/17.
 */
public class ContainsDuplicateIII {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(t==0){
            return containsNearbyDuplicate(nums,k);
        }
        for(int i=0;i<nums.length-1;i++){
            for (int j=i+1;j<nums.length&& j<=i+k;j++){
                long a = (long)nums[j]-(long)nums[i];
                if(Math.abs(a) <= t){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int a = map.get(nums[i]);
                if(i-a<=k){
                    return true;
                }
            }
            map.put(nums[i],i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,2147483647};
        System.out.println(containsNearbyAlmostDuplicate(nums,1,2147483647));
    }
}
