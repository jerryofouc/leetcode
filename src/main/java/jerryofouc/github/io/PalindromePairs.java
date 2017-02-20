package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaojiez on 2/19/17.
 */
public class PalindromePairs {
    public static List<List<Integer>> palindromePairs(String[] words) {
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],i);
        }

        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<words.length;i++){

            for(int j=0;j<words[i].length();j++){
                if(isPalin(words[i],j)){
                    String reverse = new StringBuilder(words[i].substring(j)).reverse().toString();
                    if(map.containsKey(reverse)){
                        List<Integer> array = new ArrayList<>();
                        int k = map.get(reverse);
                        if(k == i){
                            continue;
                        }
                        array.add(k);
                        array.add(i);
                        result.add(array);
                    }
                }
            }

            for(int j=words[i].length()-1;j>0;j--){
                if(isPalin(words[i],j,words[i].length()-1)){
                    String reverse = new StringBuilder(words[i].substring(0,j)).reverse().toString();
                    if(map.containsKey(reverse)){
                        List<Integer> array = new ArrayList<>();
                        int k = map.get(reverse);
                        if(k == i){
                            continue;
                        }
                        array.add(i);
                        array.add(k);
                        result.add(array);
                    }

                }
            }
        }

        for(int i=0;i<words.length;i++){
            if(isPalin(words[i],words[i].length()) && !words[i].equals("")){
                Integer k = map.get("");
                if(k != null){
                    List<Integer> array = new ArrayList<>();
                    array.add(k);
                    array.add(i);
                    result.add(array);
                    array = new ArrayList<>();
                    array.add(i);
                    array.add(k);
                    result.add(array);
                }



            }
        }


        return result;
    }

    private static boolean isPalin(String word, int s, int e) {
        while (s<e){
            if(word.charAt(s) != word.charAt(e)){
                return false;
            }
            s++;
            e--;
        }
        return true;
    }


    private static boolean isPalin(String word, int l) {
        if(l <=1){
            return true;
        }
        int s =0,e = l-1;
        while (s<e){
            if(word.charAt(s) != word.charAt(e)){
                return false;
            }
            s++;
            e--;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"abcd", "dcba", "lls", "s", "sssll"};
        System.out.println(palindromePairs(words));
    }


}
