package jerryofouc.github.io;

/**
 * Created by xiaojiez on 2/11/17.
 */
public class SuperUglyNumber {
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] a = new int[n];
        a[0] = 1;

        int[] idx = new int[primes.length];
        for(int i=1;i<n;i++){
            int min = Integer.MAX_VALUE;
            for(int j=0;j<primes.length;j++){
                if(primes[j]*a[idx[j]]<min){
                    min = primes[j]*a[idx[j]];
                }
            }
            for(int j=0;j<primes.length;j++){
                if(min == primes[j]*a[idx[j]]){
                    idx[j]++;
                }
            }
            a[i] = min;
        }

        return a[n-1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 13, 19};
        System.out.println(nthSuperUglyNumber(12,nums));
    }
}
