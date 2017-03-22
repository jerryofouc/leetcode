package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xiaojiez on 3/22/17.
 */
public class IncreasingSubsequences {
    public static List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> integerSet = new HashSet<>();
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        for(int i=1;i<nums.length;i++){
            Set<List<Integer>> toAddSet = new HashSet<>();
            for(int j=0;j<i;j++){
                if(nums[i]>=nums[j]){
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[j]);
                    l.add(nums[i]);
                    toAddSet.add(l);
                }
            }
            for(List<Integer> l :integerSet){
                if(nums[i]>=l.get(l.size()-1)){
                    List<Integer> la = new ArrayList<>(l);
                    la.add(nums[i]);
                    toAddSet.add(la);
                }
            }
            integerSet.addAll(toAddSet);
        }
        return new ArrayList<>(integerSet);
    }

    public static void main(String[] args) {
        int[] nums = {4, 6, 7, 7};
        System.out.println(findSubsequences(nums));
    }
}
