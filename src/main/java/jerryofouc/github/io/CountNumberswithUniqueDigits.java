package jerryofouc.github.io;

/**
 * Created by xiaojiez on 2/22/17.
 */
public class CountNumberswithUniqueDigits {
    public static int countNumbersWithUniqueDigits(int n) {
        if(n==0){
            return 1;
        }
        int result = 0;
        for(int i=1;i<=n;i++){
            result += getCurrent(i);
        }
        return result;
    }

    private static int getCurrent(int n) {
        if(n == 1){
            return 10;
        }
        int first = 9;
        int result = 9;
        for(int i=1;i<n;i++){
            result = first*result;
            if(first>0){
                first--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(1));
    }

}
