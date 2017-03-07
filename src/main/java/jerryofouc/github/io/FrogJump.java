package jerryofouc.github.io;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaojiez on 3/7/17.
 */
public class FrogJump {
    static class Tuple{
        int left;
        int right;

        public Tuple(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Tuple)) return false;

            Tuple tuple = (Tuple) o;

            if (left != tuple.left) return false;
            return right == tuple.right;
        }

        @Override
        public int hashCode() {
            int result = left;
            result = 31 * result + right;
            return result;
        }
    }

    public static boolean canCross(int[] stones) {
        Map<Tuple,Boolean> map = new HashMap<>();
        if(stones[0] != 0||stones[1] != 1){
            return false;
        }
        Map<Integer,Integer> stoneIndexMap = new HashMap<>();
        for(int i=0;i<stones.length;i++){
            stoneIndexMap.put(stones[i],i);
        }
        return canCross(1,1,stones,map,stoneIndexMap);
    }

    private static boolean canCross(int index, int k, int[] stones, Map<Tuple, Boolean> map,Map<Integer,Integer> stoneIndexMap) {

        if(map.containsKey(new Tuple(index,k))){
            return map.get(new Tuple(index,k));
        }
        if(index == stones.length-1){
            return true;
        }
        if(k<=0){
            return false;
        }
        int next = stones[index]+k+1;
        if(stoneIndexMap.containsKey(next)){
            boolean canCross1 = canCross(stoneIndexMap.get(next),k+1,stones,map,stoneIndexMap);
            if(canCross1){
                return true;
            }
        }
        next = stones[index]+k;
        if(stoneIndexMap.containsKey(next)){
            boolean canCross1 = canCross(stoneIndexMap.get(next),k,stones,map,stoneIndexMap);
            if(canCross1){
                return true;
            }
        }
        next = stones[index]+k-1;
        if(stoneIndexMap.containsKey(next)){
            boolean canCross1 = canCross(stoneIndexMap.get(next),k-1,stones,map,stoneIndexMap);
            if(canCross1){
                return true;
            }
        }

        map.put(new Tuple(index,k),false);
        return false;
    }

    public static void main(String[] args) {
        int[] stones = new int[]{0,1,3,5,6,8,12,17};
        System.out.println(canCross(stones));
    }
}
