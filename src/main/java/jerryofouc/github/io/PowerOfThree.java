package jerryofouc.github.io;

/**
 * Created by xiaojiez on 2/13/17.
 */
public class PowerOfThree {
    public static boolean isPowerOfThree(int n) {
        if(n==1){
            return true;
        }
        if(n < 3){
            return false;
        }
        long i=3;
        int lastI = 3;

        while (i<=n){
            lastI = (int)i;
            i = i*i;
        }


        while (n != 1){
            if(lastI <= n){
                if(lastI == 1){
                    return false;
                }
                if(n%lastI != 0){
                    return false;
                }
                n = n/lastI;
            }
            lastI = (int)Math.sqrt(lastI);

        }

        return true;


    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(6));
    }
}
