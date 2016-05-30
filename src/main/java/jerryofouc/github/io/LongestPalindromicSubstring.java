package jerryofouc.github.io;

/**
 * @author zhangxiaojie
 *         2014-11-30 17:34
 *         功能介绍:
 */
public class LongestPalindromicSubstring {
    public static void main(String args[]){
        System.out.println(longestPalindrome("abcba"));
    }

    public static String longestPalindrome(String s) {
        char[] sr = s.toCharArray();
        int l = s.length();
        int r[][] = new int[l][l+1];
        int maxBegin = 0,maxEnd = 0;
        for(int i=0;i<l;i++){
            r[i][0] = 1;
        }

        for(int i=0;i<l-1;i++){
            if(sr[i] == sr[i+1]){
                r[i][1] = 1;
                maxBegin = i;
                maxEnd = i+1;
            }
        }

        for(int i=2;i<l;i++){
            for(int j=0;j<l-i;j++){
                if(r[j+1][i-2] == 1 && sr[j] == sr[i+j]){
                    maxBegin = j;
                    maxEnd = i+j;
                    r[j][i]=1;
                }
            }
        }

        return s.substring(maxBegin,maxEnd+1);
    }
}
