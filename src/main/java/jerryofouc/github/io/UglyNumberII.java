package jerryofouc.github.io;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaojiez on 1/31/17.
 */
public class UglyNumberII {
    public static int nthUglyNumber(int n) {
        Set<Long> minInteger = new HashSet<>();
        int th = 0;
        minInteger.add(1L);
        while (true){
            long min = Long.MAX_VALUE;

            for(Long i:minInteger){
                if(min>i){
                    min = i;
                }
            }


            minInteger.remove(min);
            if(++th == n){
                return (int)min;
            }
            minInteger.add(min*2);
            minInteger.add(min*3);
            minInteger.add(min*5);
        }
    }

    public static void main(String[] args) {
        for(int i=1;i<1690;i++){
            System.out.println(nthUglyNumber(i));
        }
    }
}
