package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaojiez on 1/14/17.
 */
public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        return permute(nums,0);
    }

    private static List<List<Integer>> permute(int[] nums, int start) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(start == nums.length-1){
            List<Integer> a = new ArrayList<Integer>();
            a.add(nums[start]);
            result.add(a);
            return result;
        }

        List<List<Integer>> subResult = permute(nums,start+1);
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
        int[] nums = new int[]{1,2,3};
        System.out.println(permute(nums));
    }
}
