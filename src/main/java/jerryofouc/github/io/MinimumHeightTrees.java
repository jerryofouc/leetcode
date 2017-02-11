package jerryofouc.github.io;

import java.util.*;

/**
 * Created by xiaojiez on 2/10/17.
 */
public class MinimumHeightTrees {
    public static class Tuple<X, Y> {
        public final X x;
        public final Y y;
        public Tuple(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n <= 1){
            List<Integer> ret = new ArrayList<>();
            ret.add(0);
            return ret;
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            Set<Integer> set = map.get(edges[i][0]);
            if (set == null) {
                set = new HashSet<>();
            }
            set.add(edges[i][1]);
            map.put(edges[i][0], set);

            set = map.get(edges[i][1]);
            if (set == null) {
                set = new HashSet<>();
            }
            set.add(edges[i][0]);
            map.put(edges[i][1], set);
        }

        while (map.size()>2){
            List<Tuple> map1 = new ArrayList<>();
            Iterator<Integer> iterator = map.keySet().iterator();

            while (iterator.hasNext()){
                Integer integer = iterator.next();
                Set<Integer> set = map.get(integer);
                if(set.size() == 1){
                    map1.add(new Tuple(new ArrayList<>(set).get(0),integer));
                    iterator.remove();
                }
            }

            for(Tuple t : map1){
                map.get(t.x).remove(t.y);
            }
        }
        return new ArrayList<>(map.keySet());
    }



    public static void main(String[] args) {
        int[][] edges = new int[][]{{0,1},{0,2},{0,3},{3,4},{4,5}};
        System.out.println(findMinHeightTrees(6, edges));
    }
}
