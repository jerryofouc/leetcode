package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/12/17.
 */
public class MultiplyStrings {
    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        String result = "";
        String numZero = "";
        for(int i=1;i<=num1.length();i++){
            int num = num1.charAt(num1.length()-i) - '0';
            String muti = num2+numZero;
            String mutiResult = mutiplyOneNumber(muti,num);
            if(result.equals("")) {
                result = mutiResult;
            }else {
                result = add(result,mutiResult);
            }
            numZero += "0";
        }
        return result;
    }

    public static String mutiplyOneNumber(String num1,int num){
        String result = "";
        int carry = 0;
        for(int i=1;i<=num1.length();i++){
            int a = num1.charAt(num1.length()-i)-'0';
            result =  (a*num+carry)%10 + result;
            carry = (a*num+carry)/10;
        }
        if(carry>0){
            result = carry+result;
        }
        return result;
    }

    public static String add(String num1,String num2){
        int carry = 0;
        int smallLength = num1.length()<num2.length()?num1.length():num2.length();
        String result = "";
        int num1Length = num1.length();
        int num2Length = num2.length();
        for(int i=1;i<=smallLength;i++){
            int first = num1.charAt(num1Length-i)-'0';
            int second = num2.charAt(num2Length-i)-'0';
            result = (first+second+carry)%10 +result;
            carry = (first+second+carry)/10;

        }
        String maxNum = num1Length>num2Length?num1:num2;

        while (smallLength<maxNum.length()){
            int a = maxNum.charAt(maxNum.length()-smallLength-1)-'0';
            result =  (a+carry)%10+result;
            carry = (a+carry)/10;
            smallLength++;
        }

        if(carry>0){
            result = carry+result;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(multiply("123","456"));
    }
}
