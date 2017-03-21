package jerryofouc.github.io;

import java.util.*;

/**
 * Created by xiaojiez on 3/20/17.
 */
public class ConcatenatedWords {
    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        if(words == null || words.length ==0){
            return new ArrayList<>();
        }

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()<o2.length()){
                    return -1;
                }else if(o1.length()>o2.length()){
                    return 1;
                }else {
                    return 0;
                }
            }
        });
        HashSet<String> set = new HashSet<>();
        set.add(words[0]);
        List<String> result = new ArrayList<>();
        for(int i=1;i<words.length;i++){
            if(isContain(words[i],set)){
                result.add(words[i]);
            }else {
                set.add(words[i]);
            }
        }
        return result;
    }

    private static boolean isContain(String word, HashSet<String> set) {
        if(word.length()<=0){
            return false;
        }else {
            for(int i=1;i<=word.length();i++){
                if(set.contains(word.substring(0,i))){
                    if(i<word.length()){
                        if(isContain(word.substring(i),set)){
                            return true;
                        }
                    }else {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        System.out.println(findAllConcatenatedWordsInADict(words));
    }
}
