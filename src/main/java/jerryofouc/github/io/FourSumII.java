package jerryofouc.github.io;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaojiez on 3/16/17.
 */
public class FourSumII {
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map1 = new HashMap<>();
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                Integer sum = map1.get(A[i]+B[j]);
                if(sum == null){
                    sum = 0;
                }
                map1.put(A[i]+B[j],++sum);
            }
        }

        Map<Integer,Integer> map2 = new HashMap<>();
        for(int i=0;i<C.length;i++){
            for(int j=0;j<D.length;j++){
                Integer sum = map2.get(C[i]+D[j]);
                if(sum == null){
                    sum = 0;
                }
                map2.put(C[i]+D[j],++sum);
            }
        }

        int result = 0;
        for(Map.Entry<Integer,Integer> entry1 : map1.entrySet()){
            int key = entry1.getKey();
            Integer num2 = map2.get(-key);
            if(num2 != null){
                result += entry1.getValue()*num2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1,2};
        int[] B = {-2,-1};
        int[] C = {-1,2};
        int[] D = {0,2};

        System.out.println(fourSumCount(A,B,C,D));
    }
}
