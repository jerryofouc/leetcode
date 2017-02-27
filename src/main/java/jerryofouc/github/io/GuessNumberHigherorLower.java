package jerryofouc.github.io;

/**
 * Created by xiaojiez on 2/27/17.
 */

public class GuessNumberHigherorLower extends GuessGame{
    public int guessNumber(int n) {
        int min = 1,max = n;
        while (true){
            int m = min + (max-min)/2;
            int g = this.guess(m);
            if(g==0){
                return m;
            }else if(g == 1){
                min = m+1;
            }else {
                max = m-1;
            }
        }
    }
}
