package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xiaojiez on 3/12/17.
 */
public class FindRightInterval {
    static class Pair{
        int index;
        Interval interval;

        public Pair(int index, Interval interval) {
            this.index = index;
            this.interval = interval;
        }
    }
    public static int[] findRightInterval(Interval[] intervals) {
        List<Pair> pairList = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            pairList.add(new Pair(i,intervals[i]));
        }
        Collections.sort(pairList, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.interval.start<o2.interval.start){
                    return -1;
                }else if(o1.interval.start>o2.interval.start){
                    return 1;
                }else {
                    return 0;
                }
            }
        });

        int[] result = new int[intervals.length];
        for(int i=0;i<intervals.length;i++){
            int end = intervals[i].end;
            int iStart = 0;
            int iEnd = pairList.size()-1;
            int ri = -1;
            while (iStart<=iEnd){
                int iMid = iStart + (iEnd-iStart)/2;
                int midStart = pairList.get(iMid).interval.start;
                if(midStart>end){
                    iEnd = iMid-1;
                }else if(midStart<end){
                    iStart = iMid+1;
                }else {
                    ri = iMid;
                    break;
                }
            }
            if(ri == -1){
                ri = iStart;
            }
            if(ri<pairList.size()){
                result[i] = pairList.get(ri).index;
            }else {
                result[i] = -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1,4}, {2,3}, {3,4}};
        Interval[] intervals = new Interval[a.length];
        for(int i=0;i<a.length;i++){
            intervals[i] = new Interval();
            intervals[i].start = a[i][0];
            intervals[i].end = a[i][1];
        }
        System.out.println(findRightInterval(intervals));
    }
}
