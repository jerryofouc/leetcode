package jerryofouc.github.io;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaojiez on 3/1/17.
 */
public class FirstUniqueCharacterinaString {
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            Integer integer = map.get(s.charAt(i));
            if(integer == null){
                integer = 0;
            }
            integer++;
            map.put(s.charAt(i),integer);
        }
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
}
