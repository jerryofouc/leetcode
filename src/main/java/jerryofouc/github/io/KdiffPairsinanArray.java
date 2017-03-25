package jerryofouc.github.io;

import java.util.*;

/**
 * Created by xiaojiez on 3/25/17.
 */
public class KdiffPairsinanArray {
    static class Pair{
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;

            Pair pair = (Pair) o;

            if (i != pair.i) return false;
            return j == pair.j;
        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }
    }
    public static int findPairs(int[] nums, int k) {
        if(k == 0){
            int sum = 0;
            Map<Integer,Integer> map = new HashMap<>();
            for(int i=0;i<nums.length;i++){
                int a = map.getOrDefault(nums[i],0);
                if(a == 1){
                    sum++;
                }
                map.put(nums[i],a+1);
            }
            return sum;
        }else if(k>0){
            HashSet<Integer> set = new HashSet<>();
            for(int i=0;i<nums.length;i++){
                set.add(nums[i]);
            }
            Iterator<Integer> integerIterator = set.iterator();
            Set<Pair> pairs = new HashSet<>();
            while (integerIterator.hasNext()){
                int i = integerIterator.next();
                if(set.contains(i+k)){
                    pairs.add(new Pair(i,i+k));
                }
                if(set.contains(i-k)){
                    pairs.add(new Pair(i-k,i));
                }
            }
            return pairs.size();
        }else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 1, 5, 4};
        System.out.println(findPairs(nums,0));
    }
}
