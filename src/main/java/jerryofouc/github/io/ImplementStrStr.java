package jerryofouc.github.io;

/**
 * Created by xiaojiezhang on 11/10/16.
 */
public class ImplementStrStr {
    public static int strStr(String haystack, String needle) {
        if(haystack.equals("") && needle.equals("")){
            return 0;
        }
        char[] hh = haystack.toCharArray();
        char[] nn = needle.toCharArray();
        for(int i=0;i<haystack.length()-needle.length()+1;i++){
            boolean isOK = true;
            for(int j=0;j<needle.length();j++){
                if(hh[i+j] != nn[j]){
                    isOK = false;
                    break;
                }
            }
            if(isOK){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("mississippi","a"));
        String a = "a";
        String b = "a,b";
        a.indexOf(a);
    }
}
