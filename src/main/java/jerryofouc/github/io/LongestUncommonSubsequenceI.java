package jerryofouc.github.io;

/**
 * Created by xiaojiez on 4/2/17.
 */
public class LongestUncommonSubsequenceI {
    public int findLUSlength(String a, String b) {
        if(a.length() == b.length()){
            if(a.equals(b)){
                return -1;
            }else {
                return a.length();
            }
        }else {
            return Math.max(a.length(),b.length());
        }
    }
}
