package jerryofouc.github.io;

/**
 * Created by xiaojiezhang on 11/11/16.
 */
public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        int sign;
        if(divisor == 0){
            return Integer.MAX_VALUE;
        }
        if(dividend==0){
            return 0;
        }
        if(dividend<0&&divisor<0 || dividend>0&&divisor>0){
            sign = 1;
        }else {
            sign = -1;
        }

        long dividendLong = dividend;
        if(dividendLong < 0){
            dividendLong = -(dividendLong);
        }
        long divisorLong = divisor;
        if(divisorLong < 0){
            divisorLong = -divisorLong;
        }

        long result = getPositiveResult(dividendLong,divisorLong);
        if(sign == 1){
            if(result>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            return (int)result;
        }else {
            return (int)(-result);
        }
    }

    private static long getPositiveResult(long dividendLong, long divisorLong) {
        if(dividendLong<divisorLong){
            return 0;
        }

        long lastTotal = 0;
        long lastI = 0;
        long total = divisorLong;
        long i=1;


        for(;total<=dividendLong;){
            lastTotal = total;
            total = total+total;
            lastI = i;
            i= i+i;
        }

        long result = getPositiveResult(dividendLong-lastTotal,divisorLong);

        return lastI+result;
    }

    public static void main(String[] args) {
        System.out.println(divide(2,1));
    }
}
