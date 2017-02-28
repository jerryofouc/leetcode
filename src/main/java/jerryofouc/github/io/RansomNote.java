package jerryofouc.github.io;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaojiez on 2/28/17.
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<magazine.length();i++){
            Integer num = map.get(magazine.charAt(i));
            if(num == null){
                num = 0;
            }
            num++;
            map.put(magazine.charAt(i),num);
        }

        for(int i=0;i<ransomNote.length();i++){
            Integer num = map.get(ransomNote.charAt(i));
            if(num == null || num == 0){
                return false;
            }
            map.put(ransomNote.charAt(i),--num);
        }
        return true;
    }
}
