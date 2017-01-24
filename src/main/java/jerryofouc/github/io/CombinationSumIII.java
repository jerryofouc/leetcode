package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaojiez on 1/24/17.
 */
public class CombinationSumIII {
    static class Tuple{
        int k;
        int n;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Tuple)) return false;

            Tuple tuple = (Tuple) o;

            if (k != tuple.k) return false;
            return n == tuple.n;
        }

        @Override
        public int hashCode() {
            int result = k;
            result = 31 * result + n;
            return result;
        }
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        return combinationSum3(1,k,n);

    }

    private static List<List<Integer>> combinationSum3(int i, int k, int n) {
        if(9-i+1<k){
            return new ArrayList<List<Integer>>();
        }
        if((i+9)*(9-i+1)/2<n || (i+i+k-1)*k/2>n){
            return new ArrayList<List<Integer>>();
        }

        if(k == 1){
            if(n<i||n>9){
                return new ArrayList<List<Integer>>();
            }else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(n);
                List<List<Integer>> result = new ArrayList<List<Integer>>();
                result.add(list);

                return result;
            }
        }else {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            List<List<Integer>> l = combinationSum3(i+1,k,n);
            result.addAll(l);
            List<List<Integer>> r = combinationSum3(i+1,k-1,n-i);
            if(!r.isEmpty()){
                for(List<Integer> list : r){
                    list.add(i);
                }
                result.addAll(r);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum3(3,9));
    }
}
