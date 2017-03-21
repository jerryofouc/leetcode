package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/21/17.
 */
public class LicenseKeyFormatting {
    public static String licenseKeyFormatting(String S, int K) {
        int sum = 0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i) != '-'){
                sum ++;
            }
        }
        int firstLength = sum%K;
        StringBuilder result = new StringBuilder();
        int i=0;
        int j =0;
        if(firstLength>0){
            for(;j<firstLength;){
                char a = S.charAt(i);
                if(a != '-'){
                    if(a>='a' && a<='z'){
                        result.append((char)(a + 'A'-'a'));
                    }else {
                        result.append(a);
                    }
                    j++;
                    sum--;
                }
                i++;
            }
        }
        for(;i<S.length();){
            if(sum==0){
                return result.toString();
            }
            if(i != 0){
                result.append("-");
            }
            j = 0;
            while (j<K){
                char a = S.charAt(i);
                if(a != '-'){
                    if(a>='a' && a<='z'){
                        result.append((char)(a + 'A'-'a'));
                    }else {
                        result.append(a);
                    }
                    j++;
                    sum--;
                }
                i++;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("a-a-a-a-",3));
    }
}
