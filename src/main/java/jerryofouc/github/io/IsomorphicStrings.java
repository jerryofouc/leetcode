package jerryofouc.github.io;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaojiez on 1/21/17.
 */
public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<Character,Character> map =new HashMap<Character, Character>();
        Map<Character,Character> reverseMap =new HashMap<Character, Character>();

        for(int i=0;i<s.length();i++){
            Character mapChar = map.get(s.charAt(i));
            Character reverseChar = reverseMap.get(t.charAt(i));
            if(mapChar == null && reverseChar ==null){
                map.put(s.charAt(i),t.charAt(i));
                reverseMap.put(t.charAt(i),s.charAt(i));
            }else {
                if(reverseChar != null && mapChar!=null&& mapChar.equals(t.charAt(i))){
                    continue;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("aa","bb"));
    }
}
