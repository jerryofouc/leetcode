package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/24/17.
 */
public class LongestPalindromicSubsequence {
    public static int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            dp[i][i] = 1;
        }

        for(int l=1;l<s.length();l++){
            for(int i=0;i+l<s.length();i++){
                int j = i+l;
                if(s.charAt(i) == s.charAt(j)){
                    if(i+1==j){
                        dp[i][j] = 2;
                    }else {
                        dp[i][j] = 2+dp[i+1][j-1];
                    }
                }else {
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));
    }
}
