package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by xiaojiez on 8/2/17.
 */
public class SmallestRange {
    static class Pair implements Comparable<Pair>{
        int index;
        int value;
        int list;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;

            Pair pair = (Pair) o;

            if (getIndex() != pair.getIndex()) return false;
            if (getValue() != pair.getValue()) return false;
            return list == pair.list;
        }

        @Override
        public int hashCode() {
            int result = getIndex();
            result = 31 * result + getValue();
            result = 31 * result + list;
            return result;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.value>o.value){
                return 1;
            }else if(this.value < o.value){
                return -1;
            }else {
                if(this.index > o.index){
                    return 1;
                }else if(this.index <o.index){
                    return -1;
                }else {
                    if(this.list >o.list){
                        return 1;
                    }else {
                        if(this.list <o.list){
                            return -1;
                        }else {
                            return 0;
                        }
                    }
                }
            }
        }
    }
    public static int[] smallestRange(List<List<Integer>> nums) {
        TreeSet<Pair> treeSet = new TreeSet();
        for(int i=0;i<nums.size();i++){
            Pair pair = new Pair();
            pair.index = 0;
            pair.value = nums.get(i).get(0);
            pair.list = i;
            treeSet.add(pair);
        }
        int[] result = new int[]{-100000,100000};
        while (true){
            Pair min = treeSet.first();
            Pair max = treeSet.last();
            if(result[1]-result[0]>max.value - min.value){
                result[1] = max.value;
                result[0] = min.value;
            }
            treeSet.remove(min);
            if(min.index == nums.get(min.list).size()-1){
                return result;
            }else {
                Pair pair = new Pair();
                pair.index = min.index+1;
                pair.value = nums.get(min.list).get(min.index+1);
                pair.list = min.list;
                treeSet.add(pair);
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = {{13,58,67,78,82,88},
                {33,64,66,70,72,73,74},
                {15,62,64,70,77,85,86,87,89},
                {-3,10,24,29},
                {-46,27,28,29,30},
                {43,45,59,62,64,65,68},
                {-2,9,16,22,22,24,25},
                {10,10,10,11,12,12,12,12,14},
                {-21,-8,-4,-3,11,18},
                {-10,-4,-4,15,31,32,34,48,49,50,51},
                {-12,32,36,43,69,70,72},
                {78,79,82},
                {-37,20,26,30},
                {25,27,28},
                {9,23,25},
                {53,53,62,81,84,84,86,86,86,88,90},
                {-12,10,24,26},
                {-34,6,9,11,14,16},
                {19,43,51,75,80,82},
                {-51,-43,-8,-4,36,39,54,54,56}
    };
        List<List<Integer>> ll = new ArrayList<>();
        for(int i=0;i<a.length;i++){
            List<Integer>  l = new ArrayList<>();
            for(int j=0;j<a[i].length;j++){
                l.add(a[i][j]);
            }
            ll.add(l);
        }

        List<Integer> l = new ArrayList<>();
        System.out.println(smallestRange(ll));
    }
}
