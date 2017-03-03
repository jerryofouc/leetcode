package jerryofouc.github.io;

import java.util.*;

/**
 * Created by xiaojiez on 3/2/17.
 */
public class PerfectRectangle {
    public static boolean isRectangleCover(int[][] rectangles) {
        Map<List<Integer>,Integer> map1 = new HashMap<>();
        Map<List<Integer>,Integer> map2 = new HashMap<>();
        Map<List<Integer>,Integer> map3 = new HashMap<>();
        Map<List<Integer>,Integer> map4 = new HashMap<>();
        for(int i=0;i<rectangles.length;i++){
            List<Integer> a = new ArrayList<>();
            a.add(rectangles[i][0]);
            a.add(rectangles[i][1]);
            if(map1.containsKey(a)){
                return false;
            }
            map1.put(a,i);
            a = new ArrayList<>();
            a.add(rectangles[i][0]);
            a.add(rectangles[i][3]);
            if(map2.containsKey(a)){
                return false;
            }
            map2.put(a,i);
            a = new ArrayList<>();
            a.add(rectangles[i][2]);
            a.add(rectangles[i][3]);
            if(map3.containsKey(a)){
                return false;
            }
            map3.put(a,i);
            a = new ArrayList<>();
            a.add(rectangles[i][2]);
            a.add(rectangles[i][1]);
            if(map4.containsKey(a)){
                return false;
            }
            map4.put(a,i);
        }

        Iterator<Map.Entry<List<Integer>,Integer>> entryIterator = map1.entrySet().iterator();
        while (entryIterator.hasNext()){
            List<Integer> next = entryIterator.next().getKey();
            if(map2.containsKey(next)){
                map2.remove(next);
                entryIterator.remove();
            }else if(map4.containsKey(next)){
                map4.remove(next);
                entryIterator.remove();
            }
        }

        entryIterator = map2.entrySet().iterator();
        while (entryIterator.hasNext()){
            List<Integer> next = entryIterator.next().getKey();
            if(map3.containsKey(next)){
                map3.remove(next);
                entryIterator.remove();
            }
        }

        entryIterator = map3.entrySet().iterator();
        while (entryIterator.hasNext()){
            List<Integer> next = entryIterator.next().getKey();
            if(map4.containsKey(next)){
                map4.remove(next);
                entryIterator.remove();
            }
        }

        return map1.size() == 1&&map2.size() == 1&&map3.size() == 1&&map4.size() == 1;
    }

    public static void main(String[] args) {
        int[][] rectangles = new int[][]{{1,1,3,3},
                {3,1,4,2},
                {3,2,4,4},
                {1,3,2,4},
                {2,3,3,4}};
        System.out.println(isRectangleCover(rectangles));
    }
}
