package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/31/17.
 */
public class UglyNumber {
    public static boolean isUgly(int num) {
        if(num == 1){
            return true;
        }
        int[] a = new int[]{2,3,5};
        for(int i:a){
            while (num%i == 0){
                num = num/i;
            }
        }
        return num == 1;
    }

    public static void main(String[] args) {
        System.out.println(isUgly(14));
    }


}
