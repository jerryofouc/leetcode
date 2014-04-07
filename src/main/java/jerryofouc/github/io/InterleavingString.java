package jerryofouc.github.io;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 4/7/14
 * Time: 8:40
 * To change this template use File | Settings | File Templates.
 */
public class InterleavingString {
    static int[][][] detectArray;

    public static boolean isInterleave(String s1, String s2, String s3) {
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        char[] s3Chars = s3.toCharArray();
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        detectArray = new int[s1.length()][s2.length()][s3.length()];
        return isInterleave(s1Chars, 0, s2Chars, 0, s3Chars, 0);
    }

    private static boolean isInterleave(char[] s1Chars, int s1Begin, char[] s2Chars, int s2Begin, char[] s3Chars, int s3Begin) {
        if (s3Begin == s3Chars.length) {
            return true;
        }
        if(s1Begin == s1Chars.length){
            for(int i=s2Begin;i<s2Chars.length;i++){
                if(s2Chars[i] != s3Chars[s3Begin+i-s2Begin]){
                    return false;
                }
            }
            return true;
        }
        if(s2Begin == s2Chars.length){
            for(int i=s1Begin;i<s1Chars.length;i++){
                if(s1Chars[i] != s3Chars[s3Begin+i-s1Begin]){
                    return false;
                }
            }
            return true;
        }
        if (detectArray[s1Begin][s2Begin][s3Begin] == 1) {
            return true;
        } else if (detectArray[s1Begin][s2Begin][s3Begin] == 2) {
            return false;
        } else {
            boolean returnValue = false;
            if (s1Begin < s1Chars.length && s3Chars[s3Begin] == s1Chars[s1Begin]) {
                returnValue = isInterleave(s1Chars, s1Begin + 1, s2Chars, s2Begin, s3Chars, s3Begin + 1);
            }
            if (!returnValue && s2Begin < s2Chars.length && s3Chars[s3Begin] == s2Chars[s2Begin]) {
                returnValue = isInterleave(s1Chars, s1Begin, s2Chars, s2Begin + 1, s3Chars, s3Begin + 1);
            }
            if (returnValue) {
                detectArray[s1Begin][s2Begin][s3Begin] = 1;
            } else {
                detectArray[s1Begin][s2Begin][s3Begin] = 2;
            }
            return returnValue;
        }
    }

    public static void main(String args[]) {
        System.out.println(isInterleave("bbbcc", "bbaccbbbabcacc", "bbbbacbcccbcbabbacc"));;
    }
}
