package jerryofouc.github.io;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by xiaojiez on 2/7/17.
 */
public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();

        int max = 0;
        for(int i=0;i<nums.length;i++){
            Map.Entry<Integer,Integer> integerIntegerEntry = treeMap.lowerEntry(nums[i]);
            int cur;
            if(integerIntegerEntry == null){
                cur = 1;

                Set<Integer> removedKeySet = new HashSet<>();
                for(Map.Entry<Integer,Integer> entry : treeMap.descendingMap().entrySet()){
                    if( entry.getKey()>nums[i]&&entry.getValue()<= cur ){
                        removedKeySet.add(entry.getKey());
                    }else {
                        break;
                    }
                }
                for(int k : removedKeySet){
                    treeMap.remove(k);
                }
                treeMap.put(nums[i],1);
                if(max<1){
                    max = 1;
                }
            }else {
                if(max<integerIntegerEntry.getValue()+1){
                    max = integerIntegerEntry.getValue()+1;
                }
                cur =integerIntegerEntry.getValue()+1;
                Set<Integer> removedKeySet = new HashSet<>();
                for(Map.Entry<Integer,Integer> entry : treeMap.descendingMap().entrySet()){
                    if( entry.getKey()>nums[i]&&entry.getValue()<= cur ){
                        removedKeySet.add(entry.getKey());
                    }else {
                        break;
                    }
                }
                for(int k : removedKeySet){
                    treeMap.remove(k);
                }
                treeMap.put(nums[i],integerIntegerEntry.getValue()+1);

            }

         }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }

}
