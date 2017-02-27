package jerryofouc.github.io;

import java.util.*;

/**
 * Created by xiaojiez on 2/26/17.
 */
public class FindKPairswithSmallestSums {

    static class Four implements Comparable<Four>{
        public Four(int v1, int v2, int i1, int i2) {
            this.v1 = v1;
            this.v2 = v2;
            this.i1 = i1;
            this.i2 = i2;
        }

        int v1;
        int v2;
        int i1;
        int i2;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Four)) return false;

            Four four = (Four) o;

            if (v1 != four.v1) return false;
            if (v2 != four.v2) return false;
            if (i1 != four.i1) return false;
            return i2 == four.i2;
        }

        @Override
        public int hashCode() {
            int result = v1;
            result = 31 * result + v2;
            result = 31 * result + i1;
            result = 31 * result + i2;
            return result;
        }

        @Override
        public int compareTo(Four o) {
            if(v1+v2>o.v1+o.v2){
                return 1;
            }else if(v1+v2<o.v1+o.v2){
                return -1;
            }else {
                if(i1>o.i1) {
                    return 1;
                }else if(i1<o.i1){
                    return -1;
                }else {
                    if(i2>o.i2){
                        return 1;
                    }else if(i2<o.i2){
                        return -1;
                    }else {
                        return 0;
                    }
                }
            }
        }

        @Override
        public String toString() {
            return "Four{" +
                    "v1=" + v1 +
                    ", v2=" + v2 +
                    ", i1=" + i1 +
                    ", i2=" + i2 +
                    '}';
        }
    }

    public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if(nums1 == null || nums1.length == 0||nums2 == null || nums2.length == 0 || k==0){
            return new ArrayList<>();
        }
        List<int[]> result = new ArrayList<>();
        TreeSet<Four> treeSet = new TreeSet<>();
        treeSet.add(new Four(nums1[0],nums2[0],0,0));
        int count = 0;
        if(count==k){
            return result;
        }
        while (!treeSet.isEmpty() && count<k){
            Four four = treeSet.first();
            treeSet.remove(four);
            result.add(new int[]{four.v1,four.v2});
            if(four.i1+1<nums1.length){
                treeSet.add(new Four(nums1[four.i1+1],nums2[four.i2],four.i1+1,four.i2));
            }
            if(four.i2+1<nums2.length){
                treeSet.add(new Four(nums1[four.i1],nums2[four.i2+1],four.i1,four.i2+1));
            }
            count++;
        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,1,2};
        int[] nums2 = new int[]{1,2,3};
        System.out.println(kSmallestPairs(nums1,nums2,10));
    }
}
