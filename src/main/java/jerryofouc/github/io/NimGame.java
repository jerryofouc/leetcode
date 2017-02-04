package jerryofouc.github.io;

/**
 * Created by xiaojiez on 2/4/17.
 */
public class NimGame {
    public static boolean canWinNim(int n) {

        if((n-1)%4 == 3){
            return false;
        }else {
            return true;
        }


    }

    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        System.out.println(canWinNim(1348820612));
        long e = System.currentTimeMillis();
        System.out.println(e-s);
    }
}
