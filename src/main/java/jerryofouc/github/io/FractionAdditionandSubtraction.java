package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaojiez on 5/21/17.
 */
public class FractionAdditionandSubtraction {
    public static String fractionAddition(String expression) {
        List<Long> numeratorList = new ArrayList<>();
        List<Long> denominatorList = new ArrayList<>();
        while (true){
            int i = expression.indexOf("/");
            numeratorList.add(Long.parseLong(expression.substring(0,i)));
            boolean isEnd = true;
            for(int j=i+1;j<expression.length();j++){
                if(expression.charAt(j) == '+' || expression.charAt(j) == '-'){
                    denominatorList.add(Long.parseLong(expression.substring(i+1,j)));
                    expression = expression.substring(j);
                    isEnd = false;
                    break;
                }
            }

            if(isEnd){
                denominatorList.add(Long.parseLong(expression.substring(i+1)));
                break;
            }
        }
        long total = 1;
        for(Long d : denominatorList){
            total = total*d;
        }
        int nTotal = 0;
        for(int i=0;i<numeratorList.size();i++){
            nTotal += numeratorList.get(i)*(total/denominatorList.get(i));
        }
        if(nTotal == 0){
            return 0  +"/"+1;
        }
        String sign = nTotal*total>0?"":"-";
        nTotal = Math.abs(nTotal);
        total = Math.abs(total);

        long gcd = getGCD(nTotal,total);
        return sign+nTotal/gcd+"/"+total/gcd;

    }

    private static long getGCD(long a, long b) {
        if(b == 0){
            return a;
        }
        return getGCD(b,a%b);
    }

    public static void main(String[] args) {
        System.out.println(fractionAddition("5/3+1/3"));
    }
}
