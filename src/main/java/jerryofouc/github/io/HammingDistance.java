package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/18/17.
 */
public class HammingDistance {
    public static int hammingDistance(int x, int y) {
        int count = 0;
        int a = 1;
        for(int i=0;i<32;i++){
            if(((x&(a<<i))^(y&(a<<i))) != 0){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1,4));
    }

}
