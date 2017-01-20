package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/20/17.
 */
public class ReverseBits {
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        int a = 0x80000000;
        int b = 0x1;
        for(int i=0;i<16;i++){
            if((n&a)==0 && (n&b) !=0){
                n=n|a;
                n=n&(~b);
            }else if((n&a)!=0 && (n&b) ==0){
                n=n&(~a);
                n=n|b;
            }
            a = (a>>>1);
            b = (b<<1);
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(2));
        System.out.println(Integer.MIN_VALUE);
        Double a = 3.432;
        System.out.println(a.intValue());
    }
}
