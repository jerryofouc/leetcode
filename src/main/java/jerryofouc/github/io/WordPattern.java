package jerryofouc.github.io;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaojiez on 2/3/17.
 */
public class WordPattern {
    public static boolean wordPattern(String pattern, String str) {
        char[] patternArray = pattern.toCharArray();
        String[] words = str.split("\\s");
        if(pattern.length() != words.length){
            return false;
        }
        Map<Character,String> a = new HashMap<>();
        Map<String,Character> b = new HashMap<>();

        for(int i=0;i<patternArray.length;i++){
            Character c = patternArray[i];
            String w = words[i];
            if(a.get(c) == null){
                if(b.containsKey(w)){
                    return false;
                }
                a.put(c,w);
                b.put(w,c);
            }else {
                if(!w.equals(a.get(c))){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba","dog cat cat fish"));
    }
}
