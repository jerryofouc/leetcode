package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/26/17.
 */
public class ReverseStringII {
    public static String reverseStr(String s, int k) {
        if(k<=1){
            return s;
        }
        StringBuilder result = new StringBuilder();
        int i=0;
        for( i=0;i+k<=s.length();i += k){
            if((i/k)%2 == 0){
                result.append(new StringBuilder(s.substring(i,i+k)).reverse());
            }else {
                result.append(s.substring(i,i+k));
            }
        }
        if((i/k)%2 == 0){
            result.append(new StringBuilder(s.substring(i)).reverse());
        }else {
            result.append(s.substring(i));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("abcd",4));
    }
}
