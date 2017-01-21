package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/21/17.
 */
public class BitwiseAndOfNumbersRange {
    public static int rangeBitwiseAnd(int m, int n) {
        if(m==n){
            return m;
        }
        int result = 0;
        int t = 1;
        int k;
        for(k=1;k<32;k++){
            if(n-m+1<=t){
                break;
            }
            t = t<<1;
        }

        return m&n&(~(t-1));

    }

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5,7));
    }
}
