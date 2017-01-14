package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/13/17.
 * 这道题是一个动态规划题
 * 一定要注意记录结果空间，把计算的结果给记下来
 * 做动态规划题：
 * 1.找到递推function
 * 2.看看结果能否通过记录，来减少重复计算
 */
public class WildcardMatching {
    public static boolean isMatch(String s, String p) {
        int[][] result = new int[s.length()+1][p.length()+1];
        for(int i=0;i<=s.length();i++){
            for(int j=0;j<=p.length();j++){
                result[i][j] = -1;
            }
        }
        return isMatch(s,0,s.length(),p,0,p.length(),result);
    }

    private static boolean isMatch(String s, int sStart, int sLength, String p, int pStart, int pLength,int[][] result) {
        boolean isAllStar = pStart != pLength;
        for(int i=pStart;i<pLength;i++){
            if(p.charAt(i) != '*'){
                isAllStar = false;
            }
        }
        if(sStart == sLength && pStart == pLength || isAllStar){
            return true;
        }
        if(sStart == sLength || pStart == pLength){
            return false;
        }

        if(result[sStart][pStart] == 0){
            return false;
        }else if(result[sStart][pStart] == 1){
            return true;
        }

        if(s.charAt(sStart) == p.charAt(pStart) || p.charAt(pStart) == '?'){
            boolean isMatched = isMatch(s,sStart+1,sLength,p,pStart+1,pLength,result);
            if(isMatched){
                result[sStart][pStart] = 1;
            }else {
                result[sStart][pStart] = 0;
            }
            return isMatched;
        }else if(p.charAt(pStart) == '*'){
            while (pStart+1<pLength && p.charAt(pStart+1) == '*'){
                pStart++;
            }
            pStart++;
            if(pStart == pLength){
                return true;
            }
            while (sStart<sLength){
                while (sStart<sLength&&s.charAt(sStart) !=  p.charAt(pStart)&& p.charAt(pStart)!='?'){
                    result[sStart][pStart] = 0;
                    sStart++;
                }
                if(sStart == sLength){
                    return false;
                }
                if(isMatch(s,sStart+1,sLength,p,pStart+1,pLength,result)){
                    result[sStart+1][pStart+1] = 1;
                    return true;
                }else {
                    result[sStart+1][pStart+1] = 0;
                }
                sStart++;
            }
            if(sStart == sLength){
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("baaabbabbbaabbbbbbabbbaaabbaabbbbbaaaabbbbbabaaaaabbabbaabaaababaabaaabaaaabbabbbaabbbbbaababbbabaaabaabaaabbbaababaaabaaabaaaabbabaabbbabababbbbabbaaababbabbaabbaabbbbabaaabbababbabababbaabaabbaaabbba",
                "*b*ab*bb***abba*a**ab***b*aaa*a*b****a*b*bb**b**ab*ba**bb*bb*baab****bab*bbb**a*a*aab*b****b**ba**abba"));
  //      System.out.println(isMatch("aa","aa"));
    }
}
