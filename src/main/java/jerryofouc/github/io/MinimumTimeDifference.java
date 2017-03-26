package jerryofouc.github.io;

import java.util.List;
import java.util.TreeSet;

/**
 * Created by xiaojiez on 3/26/17.
 */
public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(String t : timePoints){
            String[] array = t.split(":");
            int hour = Integer.valueOf(array[0]);
            int minute =hour*60+ Integer.valueOf(array[1]);
            if(treeSet.contains(minute)){
                return 0;
            }else {
                treeSet.add(minute);
            }
        }

        Integer min = Integer.MAX_VALUE;
        for(Integer i : treeSet){
            for(Integer j : treeSet){
                if(!i.equals(j)){
                    min = Math.min(min,(Math.min(Math.abs(i-j),(24*60-Math.abs(i-j)))));
                }

            }
        }
        return min;

    }
}
