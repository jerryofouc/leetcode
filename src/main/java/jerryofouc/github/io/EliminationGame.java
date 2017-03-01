package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/1/17.
 */
public class EliminationGame {
    public int lastRemaining(int n) {
        return leftToRight(n);
    }

    private int leftToRight(int n) {
        if(n<=2){
            return n;
        }
        return 2*rightToLeft(n/2);
    }

    private int rightToLeft(int n) {
        if(n<=2){
            return 1;
        }
        if(n%2 == 1){
            return 2*leftToRight(n/2);
        }else {
            return 2*leftToRight(n/2+1)-1;
        }
    }
}
