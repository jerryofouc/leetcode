package jerryofouc.github.io.next;

import java.util.*;

/**
 * Created by xiaojiez on 2/8/17.
 */
public class RussianDollEnvelopes {
    static class Pair implements Comparable<Pair> {
        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }

        int left;
        int right;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;

            Pair pair = (Pair) o;

            if (left != pair.left) return false;
            return right == pair.right;
        }

        @Override
        public int hashCode() {
            int result = left;
            result = 31 * result + right;
            return result;
        }


        @Override
        public int compareTo(Pair o) {
            if (this.left > o.left) {
                return 1;
            } else if (this.left == o.left) {
                if (this.right > o.right) {
                    return -1;
                } else if (this.right == o.right) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return -1;
            }
        }
    }

    public static int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0){
            return 0;
        }
        List<Pair> pairList = new ArrayList<>();
        for(int i=0;i<envelopes.length;i++){
            pairList.add(new Pair(envelopes[i][0],envelopes[i][1]));
        }
        Collections.sort(pairList);
        int[] a = new int[envelopes.length];
        for(int i=0;i<a.length;i++){
            a[i] = pairList.get(i).right;
        }
        int dp[] = new int[a.length];
        int sum = -1;
        for(int i=0;i<a.length;i++){
            int k = -Arrays.binarySearch(dp,0,sum+1,a[i])-1;
            if(k == sum+1){
                dp[++sum] = a[i];
            }else if(k>=0){
                dp[k] = a[i];
            }
        }
        return sum+1;
    }

    public static void main(String[] args) {
        int num[][] = {{15,8},{2,20},{2,14},{4,17},{8,19},{8,9},{5,7},{11,19},{8,11},{13,11},{2,13},{11,19},{8,11},{13,11},{2,13},{11,19},{16,1},{18,13},{14,17},{18,19}};
        System.out.println(maxEnvelopes(num));
    }
}
