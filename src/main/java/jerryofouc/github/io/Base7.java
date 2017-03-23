package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/23/17.
 */
public class Base7 {
    public String convertToBase7(int num) {
        long a = (long)num;
        if(a == 0){
            return "0";
        }
        int sign = 1;
        if(a<0){
            sign = -1;
            a = -a;
        }
        String result = "";
        while (a!=0){
            result += (a)%7;
            a = a/7;
        }

        result = new StringBuilder(result).reverse().toString();
        if(sign<0){
            return "-"+result;
        }else {
            return result;
        }

    }
}
