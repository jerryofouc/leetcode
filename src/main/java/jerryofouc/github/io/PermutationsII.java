package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xiaojiez on 1/14/17.
 */
public class PermutationsII {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        return new ArrayList<List<Integer>>(permuteUnique(nums,0));
    }

    private static Set<List<Integer>> permuteUnique(int[] nums, int start) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        if(start == nums.length-1){
            List<Integer> a = new ArrayList<Integer>();
            a.add(nums[start]);
            result.add(a);
            return result;
        }

        Set<List<Integer>> subResult = permuteUnique(nums,start+1);
        for(List<Integer> l : subResult){
            for(int i=0;i<=l.size();i++){
                List<Integer> a = new ArrayList<Integer>();
                List<Integer> prefix = new ArrayList<Integer>();
                for(int k =0;k<i;k++){
                    prefix.add(l.get(k));
                }
                a.addAll(prefix);
                a.add(nums[start]);
                List<Integer> suffix = new ArrayList<Integer>();

                for(int k=i;k<l.size();k++){
                    suffix.add(l.get(k));
                }
                a.addAll(suffix);
                result.add(a);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1};
        System.out.println(permuteUnique(nums));
    }
}
