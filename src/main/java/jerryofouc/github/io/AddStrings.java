package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/9/17.
 */
public class AddStrings {
    public static String addStrings(String num1, String num2) {
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();
        String result = "";
        int carry = 0;
        int i;
        for( i=0;i<n1.length()&&i<n2.length();i++){
            result = result + ((carry + (n1.charAt(i)-'0')+(n2.charAt(i)-'0')))%10+"";
            carry = ((carry + (n1.charAt(i)-'0')+(n2.charAt(i)-'0')))/10;
        }
        while (i<n1.length()){
            result = result + ((carry + (n1.charAt(i)-'0')))%10+"";
            carry = (carry + (n1.charAt(i)-'0'))/10;
            i++;
        }
        while (i<n2.length()){
            result = result + ((carry + (n2.charAt(i)-'0')))%10+"";
            carry = (carry + (n2.charAt(i)-'0'))/10;
            i++;
        }
        if(carry == 1){
            result += carry;
        }
        return new StringBuilder(result).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("9","99"));
    }
}
