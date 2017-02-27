package jerryofouc.github.io;

/**
 * Created by xiaojiez on 2/26/17.
 */
public class SumofTwoIntegers {
    public int getSum(int a, int b) {
        if(b == 0){
            return a;
        }
        int t = a^b;
        int carry = a&b<<1;
        return getSum(a,carry);
    }
}
