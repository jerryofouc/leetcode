package jerryofouc.github.io;

import java.util.*;

/**
 * Created by zhangxiaojie on 5/30/16.
 */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else {
                map.put(nums[i],map.get(nums[i])+1);
            }
        }

        List<Pair> pairs = new ArrayList<Pair>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            pairs.add(new Pair(entry.getValue(),entry.getKey()));
        }

        Collections.sort(pairs, new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                if(p1.getCount() < p2.getCount()){
                    return 1;
                }else if(p1.getCount() == p2.getCount()){
                    return 0;
                }else {
                    return -1;
                }
            }
        });

        List<Integer> rets = new ArrayList<Integer>();
        for(int i=0;i<k;i++){
            rets.add(pairs.get(i).getInteger());
        }
        return rets;
    }

    class Pair{
        public Pair(int count, int integer) {
            this.count = count;
            this.integer = integer;
        }

        private int count;
        private int integer;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getInteger() {
            return integer;
        }

        public void setInteger(int integer) {
            this.integer = integer;
        }
    }
}
