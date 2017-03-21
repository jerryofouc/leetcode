package jerryofouc.github.io;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

/**
 * Created by xiaojiez on 3/21/17.
 */
public class SlidingWindowMedian {
    static class Pair implements Comparable<Pair>{
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;

            Pair pair = (Pair) o;

            if (value != pair.value) return false;
            return index == pair.index;
        }

        @Override
        public int hashCode() {
            int result = value;
            result = 31 * result + index;
            return result;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.value>o.value){
                return 1;
            }else if(this.value<o.value){
                return -1;
            }else {
                if(this.index>o.index){
                    return 1;
                }else if(this.index<o.index){
                    return -1;
                }else {
                    return 0;
                }

            }
        }
    }
    public static double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length-k+1];
        if(k == 1){
            for(int i=0;i<nums.length;i++){
                result[i] = nums[i];
            }
            return result;
        }
        if(nums.length == 0){
            return result;
        }
        TreeSet<Pair> left = new TreeSet<>();
        TreeSet<Pair> right = new TreeSet<>();
        Queue<Pair> queue = new LinkedList<>();
        for(int i=0;i<k;i++){
            right.add(new Pair(nums[i],i));
            queue.add(new Pair(nums[i],i));
        }

        Iterator<Pair> rightIterator = right.iterator();
        for(int i=0;i<k/2;i++){
            left.add(rightIterator.next());
            rightIterator.remove();
        }

        int i =0;
        if(left.size() == right.size()){
            result[i++] = (double)((long)left.last().value+(long)right.first().value)/2;
        }else {
            result[i++] = (double)(right.first().value);
        }



        for(int j=1;j+k-1<nums.length;j++){
            Pair last = queue.poll();
            Integer cur = nums[j+k-1];
            queue.add(new Pair(cur,j+k-1));
            if(left.contains(last)){
                left.remove(last);
                left.add(right.pollFirst());
            }else {
                right.remove(last);
            }
            if(cur>=left.last().value){
                right.add(new Pair(cur,j+k-1));
            }else {
                right.add(left.pollLast());
                left.add(new Pair(cur,j+k-1));
            }
            if(left.size() == right.size()){
                result[i++] = (double)((long)left.last().value+(long)right.first().value)/2;
            }else {
                result[i++] = (double)(right.first().value);
            }
        }

        return result;

    }

    public static void main(String[] args) {
        //int nums[] = new int[]{1,3,-1,-3,5,3,6,7};
        int nums[] = new int[]{2147483647,2147483647};
        System.out.println(medianSlidingWindow(nums,2));
    }
}
