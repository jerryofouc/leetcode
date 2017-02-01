package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/31/17.
 */
public class AddDigits {
    public int addDigits(int num) {
        if(num/10 == 0){
            return num;
        }else {
            int next = 0;
            while (num != 0){
                next += num%10;
                num = num/10;
            }
            return addDigits(next);
        }
    }
}
