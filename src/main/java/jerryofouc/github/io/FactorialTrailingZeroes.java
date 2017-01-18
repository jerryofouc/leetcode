package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/18/17.
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int result = 0;
        while (n /5 !=0){
            result += n/5;
            n /=5;
        }
        return result;
    }
}
