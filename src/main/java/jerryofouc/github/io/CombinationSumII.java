package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by xiaojiez on 1/10/17.
 * 解题思路：同sum1，但是需要整理成sum1的格式
 */
public class CombinationSumII {
    public static class Pair{
        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public int getLeft() {
            return left;
        }

        public int getRight() {
            return right;
        }

        private int left;
        private int right;

        @Override
        public String toString() {
            return "Pair{" +
                    "left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        TreeMap<Integer,Integer> treeMap = new TreeMap<Integer, Integer>();
        for(int i=0;i<candidates.length;i++){
            if(treeMap.containsKey(candidates[i])){
                treeMap.put(candidates[i],treeMap.get(candidates[i])+1);
            }else {
                treeMap.put(candidates[i],1);
            }
        }
        List<Pair> pairs = new ArrayList<Pair>();
        for(Map.Entry<Integer,Integer> entry:treeMap.entrySet()){
            Pair pair = new Pair(entry.getKey(),entry.getValue());
            pairs.add(pair);
        }

        return combinationSum2(0,pairs,target);
    }

    private static List<List<Integer>> combinationSum2(int start,  List<Pair> pairs, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(start == pairs.size()-1){
            Pair pair = pairs.get(start);
            List<Integer> a = new ArrayList<Integer>();
            for(int i=1;i<=pair.getRight();i++){
                if(target == i*pair.getLeft()){
                    for(int k=0;k<i;k++){
                        a.add(pair.getLeft());
                    }
                }
            }
            if(a.size() != 0){
                ret.add(a);
            }
        }else {
            Pair cur = pairs.get(start);
            for(int i=0;i<=cur.getRight() && i*cur.getLeft()<=target;i++){
                if(target == i*cur.getLeft()){
                    List<Integer> a = new ArrayList<Integer>();
                    for(int k=0;k<i;k++){
                        a.add(cur.getLeft());
                    }
                    ret.add(a);
                }else{
                    List<List<Integer>> aa = combinationSum2(start+1,pairs,target-i*cur.getLeft());
                    for(List<Integer> a : aa){
                        for(int k=0;k<i;k++){
                            a.add(cur.getLeft());
                        }
                    }
                    ret.addAll(aa);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] candidate = new int[]{10, 1, 2, 7, 6, 1, 5};
        System.out.println(combinationSum2(candidate,8));
    }
}
