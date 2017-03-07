package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/6/17.
 */
public class NthDigit {
    public static int findNthDigit(int n) {
        int i = 1;
        long a = 9;
        long sum = 0;
        long actualSum = 0;

        while (n>sum+a*i){
            actualSum += a;
            sum += a*i;
            a = a*10;
            i++;
        }

        long num = actualSum+(n-sum)/i + ((n-sum)%i == 0?0:1);
        int k = (int)((n-sum)%i==0?i:(n-sum)%i);
        long[] kk = new long[i];
        for(int j=0;j<i;j++){
            kk[i-j-1] = num%10;
            num = num/10;
        }

        return (int)kk[k-1];

    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(1000000000));
    }
}
