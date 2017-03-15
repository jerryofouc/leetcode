package jerryofouc.github.io;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaojiez on 3/13/17.
 */
public class ArithmeticSlicesIISubsequence {
    public int numberOfArithmeticSlices(int[] A) {
        Map<Integer,Integer>[] maps = new Map[A.length];
        int result = 0;
        for(int i=0;i<A.length;i++){
            maps[i] = new HashMap<>();
            for(int j=0;j<i;j++){
                long diff = (long)A[i]-A[j];
                if(diff>Integer.MAX_VALUE || diff<Integer.MIN_VALUE){
                    continue;
                }
                int c1 = maps[i].getOrDefault((int)diff,0);
                int c2 = maps[j].getOrDefault((int)diff,0);
                result += c2;
                maps[i].put((int)diff,c1+c2+1);
            }
        }
        return result;
    }
}
