package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/15/17.
 */
public class Pow {
    public static double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        double result = 1;
        int sign = 1;
        if(n<0){
            sign = -1;
            n=-n;
        }
        double cur = x;
        do{
            result *= (n%2==0?1:cur);
            n = n/2;
            cur = cur*cur;
        }while (n!=0);

        if(sign>0){
            return result;
        }else {
            return (1/result);
        }
    }


    public static void main(String[] args) {
        System.out.println(myPow(8.84372,-5));
        System.out.println(Math.pow(8.84372,-5));
    }
}
