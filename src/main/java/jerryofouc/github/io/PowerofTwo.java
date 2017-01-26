package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/26/17.
 */
public class PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        if(n == 0){
            return false;
        }
        long n1 = n;
        long i =1;
        while ((n1&i)==0){
            i = i<<1;
        }
        if(i == n1){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
    }
}
