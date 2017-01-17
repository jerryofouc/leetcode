package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xiaojiez on 1/16/17.
 */
public class MergeIntervals {
    public static List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() == 0){
            return new ArrayList<Interval>();
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                if(o1.start>o2.start){
                    return 1;
                }else if(o1.start<o2.start){
                    return -1;
                }
                return 0;
            }
        });
        List<Interval> result = new ArrayList<Interval>();
        Interval curInterval = intervals.get(0);
        for(int i=1;i<intervals.size();i++){
            if(curInterval.end<intervals.get(i).start){
                result.add(curInterval);
                curInterval = intervals.get(i);
            }else {
                curInterval.end = intervals.get(i).end>curInterval.end?intervals.get(i).end:curInterval.end;
            }
        }
        result.add(curInterval);
        return result;
    }

    public static void main(String[] args) {

    }
}
