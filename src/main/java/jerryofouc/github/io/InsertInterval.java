package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaojiez on 1/16/17.
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int i;
        for(i=0;i<intervals.size();i++){
            Interval curInterval = intervals.get(i);
            if(curInterval.start<newInterval.start){
                i++;
            }
        }

        if(i==intervals.size()){
            intervals.add(newInterval);
        }else {
            intervals.add(i,newInterval);
        }


        List<Interval> result = new ArrayList<Interval>();
        Interval curInterval = intervals.get(0);
        for(i=1;i<intervals.size();i++){
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
}
