package jerryofouc.github.io;

/**
 * Created by xiaojiez on 2/9/17.
 */
public class AdditiveNumber {
    public static boolean isAdditiveNumber(String num) {
        for(int i=0;i<num.length();i++){
            for(int j=i+1;j<num.length();j++){
                if(isAdditiveNumber(num.substring(0,i+1),num.substring(i+1,j+1),num.substring(j+1))){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isAdditiveNumber(String a, String b, String c) {
        if(b.startsWith("0") && b.length()>1){
            return false;
        }
        String sumString = sum(a,b);
        if(c.startsWith(sumString)){
            if(c.equals(sumString)){
                return true;
            }else {
                return isAdditiveNumber(b,sumString,c.substring(sumString.length()));
            }
        }else {
            return false;
        }
    }

    private static String sum(String a,String b){
        int carry = 0;
        String result = "";
        String reverseA = new StringBuilder(a).reverse().toString();
        String reverseB = new StringBuilder(b).reverse().toString();
        int i;
        for(i=0;i<Math.min(a.length(),b.length());i++){
            int cur = carry + (reverseA.charAt(i)-'0') +(reverseB.charAt(i)-'0');
            carry = cur/10;
            result = result + cur%10;
        }

        String c = a.length()>b.length()?reverseA:reverseB;

        for(;i<c.length();i++){
            int cur = carry + (c.charAt(i)-'0');
            carry = cur/10;
            result = result + cur%10;
        }

        if(carry>0){
            result += carry;
        }

        return new StringBuilder(result).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(isAdditiveNumber("101"));
    }
}
