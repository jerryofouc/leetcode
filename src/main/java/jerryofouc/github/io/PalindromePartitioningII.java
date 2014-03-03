package jerryofouc.github.io;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 2/28/14
 * Time: 15:33
 * To change this template use File | Settings | File Templates.
 */
public class PalindromePartitioningII {
    private static HashMap<String, Integer> minCutMap = new HashMap<String, Integer>();//memorize the minCutMap
    private static HashMap<String, Boolean> palindromeMap = new HashMap<String, Boolean>();//memorize the palindrome

    public static int minCut(String s) {
        if (s==null||s.length()==0||s.length() == 1||isPalindrome(s)) {//if is Palindrome return true directly
            return 0;
        } else {
            if (minCutMap.get(s) != null) {
                return minCutMap.get(s);
            }
            Integer min = null;
            for (int start = 0; start < s.length(); start++) {
                if (isPalindrome(s.substring(0, start + 1))) {
                    int cut = 1 + minCut(s.substring(start + 1, s.length()));
                    if (min == null || cut < min) {
                        min = cut;
                    }
                }
            }
            minCutMap.put(s, min);
            return min;
        }
    }

    private static boolean isPalindrome(String substring) {//check if is Palindrome
        if (substring.length() == 1) {
            return true;
        } else {
            if (palindromeMap.get(substring) != null) { //check it
                return palindromeMap.get(substring);
            }
            boolean isPalindrome = false;
            if (substring.length() == 2) {
                isPalindrome = substring.charAt(0) == substring.charAt(1);
            } else {
                isPalindrome = substring.charAt(0) == substring.charAt(substring.length()-1) && isPalindrome(substring.substring(1, substring.length() - 1));
            }
            palindromeMap.put(substring, isPalindrome);//memorize it
            return isPalindrome;
        }
    }

    public static void main(String args[]){
        System.out.println(minCut("adabdcaebdcebdcacaaaadbbcadabcbeabaadcbcaaddebdbddcbdacdbbaedbdaaecabdceddccbdeeddccdaabbabbdedaaabcdadbdabeacbeadbaddcbaacdbabcccbaceedbcccedbeecbccaecadccbdbdccbcbaacccbddcccbaedbacdbcaccdcaadcbaebebcceabbdcdeaabdbabadeaaaaedbdbcebcbddebccacacddebecabccbbdcbecbaeedcdacdcbdbebbacddddaabaedabbaaabaddcdaadcccdeebcabacdadbaacdccbeceddeebbbdbaaaaabaeecccaebdeabddacbedededebdebabdbcbdcbadbeeceecdcdbbdcbdbeeebcdcabdeeacabdeaedebbcaacdadaecbccbededceceabdcabdeabbcdecdedadcaebaababeedcaacdbdacbccdbcece"));
    }

}
