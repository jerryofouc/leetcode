package jerryofouc.github.io;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaojiez on 3/24/17.
 */
public class FreedomTrail {
    static class Tuple{
        String ring;
        String key;

        public Tuple(String ring, String key) {
            this.ring = ring;
            this.key = key;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Tuple)) return false;

            Tuple tuple = (Tuple) o;

            if (ring != null ? !ring.equals(tuple.ring) : tuple.ring != null) return false;
            return key != null ? key.equals(tuple.key) : tuple.key == null;
        }

        @Override
        public int hashCode() {
            int result = ring != null ? ring.hashCode() : 0;
            result = 31 * result + (key != null ? key.hashCode() : 0);
            return result;
        }
    }
    public static int findRotateSteps(String ring, String key) {
        Map<Tuple,Integer> map = new HashMap<>();
        return find(ring,key,map);
    }

    private static int find(String ring, String key, Map<Tuple, Integer> map) {
        if(key.length() == 0){
            return 0;
        }
        if(map.containsKey(new Tuple(ring,key))){
            return map.get(new Tuple(ring,key));
        }
        char a = key.charAt(0);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<ring.length();i++){
            if(ring.charAt(i) == a){
                int clock = i;
                int antiClock = ring.length()-i;
                String newRing = ring.substring(i)+ring.substring(0,i);
                int step = Math.min(clock,antiClock)+1+(key.length() == 1?0:find(newRing,key.substring(1),map));
                min = Math.min(min,step);
            }
        }
        map.put(new Tuple(ring,key),min);
        return min;
    }

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        System.out.println(findRotateSteps("caotmcaataijjxi","oatjiioicitatajtijciocjcaaxaaatmctxamacaamjjx"));
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
    }
}
