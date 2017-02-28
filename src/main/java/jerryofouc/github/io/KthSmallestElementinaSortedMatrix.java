package jerryofouc.github.io;

import java.util.TreeSet;

/**
 * Created by xiaojiez on 2/28/17.
 */
public class KthSmallestElementinaSortedMatrix {
    static class Three implements Comparable<Three>{
        public Three(int v, int i, int j) {
            this.v = v;
            this.i = i;
            this.j = j;
        }
        int v;
        int i;
        int j;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Three)) return false;

            Three three = (Three) o;

            if (v != three.v) return false;
            if (i != three.i) return false;
            return j == three.j;
        }

        @Override
        public int hashCode() {
            int result = v;
            result = 31 * result + i;
            result = 31 * result + j;
            return result;
        }

        @Override
        public int compareTo(Three o) {
            if(this.v < o.v){
                return -1;
            }else if(this.v>o.v){
                return 1;
            }else {
                if(this.i < o.i){
                    return -1;
                }else if(this.i>o.i){
                    return 1;
                }else {
                    if(this.j<o.j){
                        return -1;
                    }else if(this.j>o.j){
                        return 1;
                    }else {
                        return 0;
                    }
                }
            }
        }
    }

    public static int kthSmallest(int[][] matrix, int k) {

        TreeSet<Three> treeSet = new TreeSet<>();
        treeSet.add(new Three(matrix[0][0],0,0));
        int count = 0;
        while (!treeSet.isEmpty() && count<k){
            Three three = treeSet.first();
            treeSet.remove(three);
            count++;
            if(count == k){
                return three.v;
            }
            if(three.i+1<matrix.length){
                treeSet.add(new Three(matrix[three.i+1][three.j],three.i+1,three.j));
            }
            if(three.j+1<matrix[0].length){
                treeSet.add(new Three(matrix[three.i][three.j+1],three.i,three.j+1));
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{ 1,  5,  9},{10, 11, 13},{12, 13, 15}};
        System.out.println(kthSmallest(matrix,8));
    }
}
