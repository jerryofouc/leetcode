package jerryofouc.github.io;


import java.util.*;

/**
 * Created by xiaojiezhang on 10/30/16.
 */
public class NonOverlappingIntervals {
    public static int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0 || intervals.length == 1) {
            return 0;
        }

        List<Pair<Integer,Interval>> startList = new ArrayList<Pair<Integer, Interval>>();
        for(int i=0;i<intervals.length;i++){
            startList.add(new Pair<Integer,Interval>(i,intervals[i]));
        }
        Collections.sort(startList, new Comparator<Pair<Integer, Interval>>() {
            public int compare(Pair<Integer, Interval> integerIntervalPair, Pair<Integer, Interval> t1) {
                if(integerIntervalPair.getValue().start>t1.getValue().start){
                    return 1;
                }else if(integerIntervalPair.getValue().start==t1.getValue().start){
                    return 0;
                }else {
                    return -1;
                }
            }
        });

        List<Integer> nextList = new ArrayList<Integer>();

        for(int i=0;i<intervals.length;i++){
            int end = startList.get(i).getValue().end;
            int iStart = 0;
            int iEnd = startList.size()-1;
            int rightPlace  = -1;
            while (iStart<=iEnd){
                int pivotIndex = (iStart+iEnd)/2;
                int pivot = startList.get(pivotIndex).value.start;
                if(end == pivot){
                    rightPlace = pivotIndex;
                    break;
                }else if(end<pivot){
                    iEnd = pivotIndex-1;
                }else {
                    iStart = pivotIndex+1;
                }
            }
            if(rightPlace == -1){
                rightPlace = iStart;
            }
            nextList.add(rightPlace);
        }

        int i = intervals.length-1;
        int[] f = new int[intervals.length+1];
        f[intervals.length] = 0;
        while (i>=0){
            f[i] = Math.max(f[i+1],f[nextList.get(i)]+1);
            i--;
        }

        return intervals.length-f[0];
    }

    public static class Pair<K,V>{
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
    public static void main(String[] args) {
        Interval[] intervals = new Interval[]{
            new Interval(1,2),new Interval(1,2),new Interval(1,2)
        };
        System.out.println(eraseOverlapIntervals(intervals));
    }
}
