package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xiaojiez on 3/23/17.
 */
public class KeyboardRow {
    public static String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        Set<Character>[] keyboard = new Set[3];
        keyboard[0] = new HashSet<>();
        char[] k1 = {'q','w','e','r','t','y','u','i','o','p'};
        char[] k2 = {'a','s','d','f','g','h','j','k','l'};
        char[] k3 = {'z','x','c','v','b','n','m'};
        Set<Character> s1 = new HashSet<>();
        for(int i=0;i<k1.length;i++){
            s1.add(k1[i]);
        }
        keyboard[0] = s1;
        Set<Character> s2 = new HashSet<>();
        for(int i=0;i<k2.length;i++){
            s2.add(k2[i]);
        }
        keyboard[1] = s2;

        Set<Character> s3 = new HashSet<>();
        for(int i=0;i<k3.length;i++){
            s3.add(k3[i]);
        }
        keyboard[2] = s3;

        for(String w : words){
            if(w.length() != 0){
                int k =0;
                String w2 = w.toLowerCase();
                if(s1.contains(w2.charAt(0))){
                    k = 0;
                }
                if(s2.contains(w2.charAt(1))){
                    k = 1;
                }
                if(s3.contains(w2.charAt(0))){
                    k = 2;
                }
                boolean isContains = true;
                for(int i=0;i<w2.length();i++){
                    if(!keyboard[k].contains(w2.charAt(i))){
                        isContains = false;
                        break;
                    }
                }
                if(isContains){
                    result.add(w);
                }
            }
        }
        String[] rr = new String[result.size()];
        for(int i=0;i<result.size();i++){
            rr[i] = result.get(i);
        }
        return rr;
    }

    public static void main(String[] args) {
        String[] a = new String[]{};
        System.out.println(findWords(a));
    }
}
