package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaojiez on 1/10/17.
 * 解题思路：背包问题
 * 动态规划：
 * f(start,target) = n[start,..] + f(start+1,target-n*start)
 */
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        return combinationSum(0,candidates,target);
    }

    private static List<List<Integer>> combinationSum(int start, int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(start == candidates.length-1){
            if(target%candidates[start] != 0){
                return ret;
            }else {
                List<Integer> v = new ArrayList<Integer>();
                for(int i=0;i<target/candidates[start];i++){
                    v.add(candidates[start]);
                }
                ret.add(v);
            }
        }else {
            int curValue = candidates[start];
            for(int i=0;curValue*i<=target;i++){
                if(target==curValue*i){
                    List<Integer> aa = new ArrayList<Integer>();
                    for(int j=0;j<i;j++){
                        aa.add(curValue);
                    }
                    ret.add(aa);
                    return ret;
                }
                List<List<Integer>> aa = combinationSum(start+1,candidates,target-curValue*i);
                if(aa.size() != 0){
                    for(List<Integer> a : aa){
                        for(int j=0;j<i;j++){
                            a.add(curValue);
                        }
                    }
                }
                ret.addAll(aa);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] candidate = new int[]{2, 3, 6, 7};
        System.out.println(combinationSum(candidate,7));
    }
}
