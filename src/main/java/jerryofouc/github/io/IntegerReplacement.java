package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/4/17.
 */
public class IntegerReplacement {
    public static int integerReplacement(int n) {
        long a = n;
        int c = 0;
        while (a!=1){
            if(a%2 == 0){
                a = a/2;
            }else if(a == 3 || Long.bitCount(a-1)<Long.bitCount(a+1)){
                a = a-1;
            }else {
                a = a+1;
            }
            c++;
        }
        return c;
    }



    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        System.out.println(integerReplacement(6));
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
    }


}
