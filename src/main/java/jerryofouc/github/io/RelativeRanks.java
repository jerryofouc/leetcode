package jerryofouc.github.io;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by xiaojiez on 3/23/17.
 */
public class RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for(int i=0;i<nums.length;i++){
            treeMap.put(nums[i],i);
        }
        String[] result = new String[nums.length];
        int i=0;
        for(Map.Entry<Integer,Integer> entry : treeMap.entrySet()){
            int rank = nums.length-i-1;
            if(rank == 0){
                result[entry.getValue()] = "Gold Medal";
            }else if(rank == 1){
                result[entry.getValue()] = "Silver Medal";
            }else if(rank == 2){
                result[entry.getValue()] = "Bronze Medal";
            }else {
                result[entry.getValue()] = ""+(rank+1);
            }
            i++;
        }
        return result;
    }
}
