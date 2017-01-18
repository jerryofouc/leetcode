package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaojiez on 1/18/17.
 */
public class FractionToRecurringDecimal {
    public static String fractionToDecimal(int numerator, int denominator) {
        long numeratorl = numerator;
        long denominatorl = denominator;
        String result ="";
        if(numeratorl>0&&denominatorl<0||numeratorl<0&&denominatorl>0){
            result += "-";
        }
        if(numeratorl<0){
            numeratorl = -numeratorl;
        }
        if(denominatorl<0){
            denominatorl = -denominatorl;
        }
        result +=numeratorl/denominatorl+"";
        numeratorl = numeratorl%denominatorl;
        if(numeratorl == 0){
            return result;
        }else {
            result += ".";
        }
        numeratorl *= 10;


        String parentheses = "";
        List<Long> seq = new ArrayList<Long>();
        seq.add(numeratorl);
        while (true){
            parentheses += numeratorl/denominatorl;
            numeratorl = numeratorl%denominatorl*10;
            if(numeratorl==0){
                return result + parentheses;
            }
            int index = seq.indexOf(numeratorl);
            if(index != -1){
                return result+parentheses.substring(0,index)+"("+parentheses.substring(index)+")";
            }else {
                seq.add(numeratorl);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(22,7));
    }
}
