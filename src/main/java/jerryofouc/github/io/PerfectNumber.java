package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/26/17.
 */
public class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if(num<=1){
            return false;
        }
        int sum = 0;
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i == 0){
                sum += i + num/i;
            }
        }
        sum += 1;
        return sum == num;
    }
}
