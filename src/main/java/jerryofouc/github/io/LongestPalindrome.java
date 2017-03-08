package jerryofouc.github.io;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaojiez on 3/8/17.
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0;i<s.length();i++){
            Integer a = map.get(s.charAt(i));
            if(a == null){
                a = 0;
            }
            map.put(s.charAt(i),a+1);
        }
        boolean hasOdd = false;
        int result =0;
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue()%2 == 1){
                hasOdd = true;
                result += entry.getValue()-1;
            }else {
                result += entry.getValue();
            }
        }
        if(hasOdd){
            return result+1;
        }else {
            return result;
        }
    }
}
