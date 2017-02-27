package jerryofouc.github.io;

/**
 * Created by xiaojiez on 2/22/17.
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if(num ==1){return true;}

        for(int i=1;i<num;i++){
            int k = num/i;
            if(i*k == num&&i==k){
                return true;
            }
            if(k<i){
                return false;
            }
        }
        return false;
    }
}
