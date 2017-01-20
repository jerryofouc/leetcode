package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/20/17.
 */
public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int result = 0;
        int a = 0x80000000;
        for(int i=0;i<32;i++){
            if((a&n) != 0){
                result++;
            }
            a = a>>>1;
        }

        return result;
    }
}
