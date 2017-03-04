package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/4/17.
 */
public class LongestSubstringwithAtLeastKRepeatingCharacters {
    public static int longestSubstring(String s, int k) {
        int[] map = new int[26];
        for(int i=0;i<s.length();i++){
            map[s.charAt(i)-'a']++;
        }
        return longest(s,k,map);
    }

    private static int longest(String s, int k, int[] map) {
        if(s.length() == 0){
            return 0;
        }
        int i = 0;
        for(;i<s.length();){
            if(map[s.charAt(i)-'a'] != 0 &&map[s.charAt(i)-'a']<k){
                i++;
            }else {
                break;
            }
        }

        int j=s.length()-1;
        for(;j>=0;){
            if(map[s.charAt(j)-'a'] != 0 &&map[s.charAt(j)-'a']<k){
                j--;
            }else {
                break;
            }
        }
        if(i<=j){
            s = s.substring(i,j+1);
        }else {
            return 0;
        }

        boolean isOk = true;
        for(i=0;i<map.length;i++){
            if(map[i] != 0 &&map[i]<k){
                isOk = false;
                break;
            }
        }
        if(isOk){
            return s.length();
        }


        int[] tmpMap = new int[26];
        i=0;
        for(;i<s.length();i++){
            if(map[s.charAt(i) - 'a']<k){
                map[s.charAt(i) - 'a']--;
                for(j=0;j<map.length;j++){
                    map[j] = map[j]-tmpMap[j];
                }
                break;
            }else {
                tmpMap[s.charAt(i) - 'a']++;
            }
        }

        return Math.max(longest(s.substring(0,i),k,tmpMap),i+1>=s.length()?0:longest(s.substring(i+1,s.length()),k,map));
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("bbaaacbd",3));
    }
}
