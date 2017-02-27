package jerryofouc.github.io;

/**
 * Created by xiaojiez on 2/26/17.
 */
public class SuperPow {
    public static int superPow(int a, int[] b) {
        int sum = 0;
        for(int i=b.length-1;i>=0;i--){
            sum += superPow(10,b.length-i-1);
        }
        return superPow(a,sum);
    }

    public static int superPow(int a, int b){
        int aa = a%1337;
        int bb = b%1337;

        long sum = 1;
        for(int i=0;i<bb;i++){
            sum = aa*sum;
        }
        return (int)(sum%1337);
    }


    public static void main(String[] args) {
        int[] num = new int[]{1,0};
        System.out.println(superPow(2,num));
    }




}
