package jerryofouc.github.io;

import java.util.Arrays;

/**
 * Created by xiaojiez on 4/2/17.
 */
public class LongestUncommonSubsequenceII   {
    public static int findLUSlength(String[] strs) {
        Arrays.sort(strs,(a,b)->-new Integer(a.length()).compareTo(new Integer(b.length())));
        for(int i=0;i<strs.length;i++){
            boolean isSub = false;
            for(int j=0;j<strs.length;j++){
                if(i!=j){
                    if(isSub(strs[i],strs[j])){
                        isSub = true;
                        break;
                    }
                }
            }
            if(!isSub){
                return strs[i].length();
            }
        }
        return -1;
    }

    private static boolean isSub(String a, String b) {
        if(a.length()>b.length()){
            return false;
        }else if(a.length() == b.length()){
            return a.equals(b);
        }else {
            if(a.charAt(0) == b.charAt(0)){
                if(a.length() == 1){
                    return true;
                }else {
                    return isSub(a.substring(1),b.substring(1));
                }
            }else {
                return isSub(a,b.substring(1));
            }
        }
    }

    public static void main(String[] args) {
        String[] strs = {"aba", "cdc", "eae"};
        System.out.println(findLUSlength(strs));
    }
}
