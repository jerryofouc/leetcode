package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/3/17.
 */
public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        if(s == null || s.length() == 0){
            return true;
        }
        int count = 0;
        for(int i=0;i<t.length();i++){
            if(t.charAt(i) == s.charAt(count)){
                count++;
                if(count == s.length()){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("axc","ahbgdc"));
    }
}
