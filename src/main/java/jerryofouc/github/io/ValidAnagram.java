package jerryofouc.github.io;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xiaojiez on 1/30/17.
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> set = new HashMap<>();
        for(Character c : s.toCharArray()){
            if(set.get(c) == null){
                set.put(c,1);
            }else {
                set.put(c,set.get(c)+1);
            }
        }

        for(Character c : t.toCharArray()){
            Integer a = set.get(c);
            if(a == null){
                return false;
            }else {
                if(a == 1){
                    set.remove(c);
                }else {
                    set.put(c,a-1);
                }
            }

        }

        return set.isEmpty();
     }
}
