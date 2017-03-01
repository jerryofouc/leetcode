package jerryofouc.github.io;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaojiez on 3/1/17.
 */
public class FindtheDifference {
    public static char findTheDifference(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            Integer k = map.get(s.charAt(i));
            if( k == null){
                k = 0;
            }
            k++;
            map.put(s.charAt(i),k);
        }
        for(int i=0;i<t.length();i++){
            Integer integer = map.get(t.charAt(i));
            if(integer == null || integer == 0){
                return t.charAt(i);
            }
            integer--;
            map.put(t.charAt(i),integer);
        }
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd","abcde"));
    }
}
