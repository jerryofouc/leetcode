package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaojiez on 1/21/17.
 */
public class CountPrimes {
    public static int countPrimes(int n) {
        if(n == 0){
            return 0;
        }
        int result = 0;
        List<Integer> primes = new ArrayList<Integer>();
        for(int i=2;i<n;i++){
            boolean isPrime = true;
            int max;
            for(Integer p : primes){
                if(i%p == 0){
                    isPrime = false;
                    break;
                }
                max = i/p;
                if(p>max){
                    break;
                }
            }
            if(isPrime){
                primes.add(i);
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(499979));
    }
}
