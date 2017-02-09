package jerryofouc.github.io.next;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by xiaojiez on 2/8/17.
 */
public class SummaryRanges {
    public static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
    /** Initialize your data structure here. */
    public static class Interval1 implements Comparable<Interval1>{
        int left;
        int right;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Interval)) return false;

            Interval1 interval = (Interval1) o;

            if (left != interval.left) return false;
            return right == interval.right;
        }

        @Override
        public int hashCode() {
            int result = left;
            result = 31 * result + right;
            return result;
        }


        @Override
        public int compareTo(Interval1 o) {
            if(this.left>o.left){
                return 1;
            }else if(this.left==o.left){
                return 0;
            }else {
                return -1;
            }
        }
    }

    private TreeSet<Interval1> treeSet = new TreeSet();
    public SummaryRanges() {
    }

    public void addNum(int val) {
        Interval1 interval = new Interval1();
        interval.left = val;
        interval.right = val;
        Interval1 cur = treeSet.floor(interval);
        if(cur == null){
            Interval1 higher = treeSet.higher(interval);
            if(higher != null){
                if(interval.left +1 == higher.left){
                    treeSet.remove(higher);
                    interval.right = higher.right;
                }
            }
            treeSet.add(interval);
        }else {
            if(cur.right<interval.left){
                if(interval.left - cur.right==1){
                    Interval1 higher = treeSet.higher(interval);
                    if(higher != null){
                        if(interval.left +1 == higher.left){
                            treeSet.remove(cur);
                            treeSet.remove(higher);
                            interval.left = cur.left;
                            interval.right = higher.right;
                            treeSet.add(interval);
                        }else {
                            treeSet.remove(cur);
                            interval.left = cur.left;
                            treeSet.add(interval);
                        }
                    }else {
                        treeSet.remove(cur);
                        interval.left = cur.left;
                        treeSet.add(interval);
                    }
                }else {
                    Interval1 higher = treeSet.higher(interval);
                    if(higher != null){
                        if(interval.left +1 == higher.left){
                            treeSet.remove(higher);
                            interval.right = higher.right;
                        }
                    }
                    treeSet.add(interval);
                }
            }
        }
    }

    public List<Interval> getIntervals() {
        List<Interval> intervalList = new ArrayList<>();
        for(Interval1 interval1 : treeSet){
            Interval interval = new Interval();
            interval.start = interval1.left;
            interval.end = interval1.right;
            intervalList.add(interval);
        }
        return intervalList;
    }

    public static void main(String[] args) {
        SummaryRanges summaryRanges = new SummaryRanges();
        summaryRanges.addNum(1);
        System.out.println(summaryRanges.getIntervals());
        summaryRanges.addNum(0);
        System.out.println(summaryRanges.getIntervals());
        summaryRanges.addNum(7);
        System.out.println(summaryRanges.getIntervals());
        summaryRanges.addNum(2);
        System.out.println(summaryRanges.getIntervals());
        summaryRanges.addNum(6);
        System.out.println(summaryRanges.getIntervals());
    }
}
