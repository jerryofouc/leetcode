package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaojiez on 3/12/17.
 */
public class FindAllAnagramsInString {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s.length()<p.length()){
            return result;
        }
        int[] mem = new int[26];
        for(int i=0;i<p.length();i++){
            mem[p.charAt(i)-'a']++;
        }
        for(int i=0;i<p.length();i++){
            mem[s.charAt(i)-'a']--;
        }

        if(isAnagram(mem)){
            result.add(0);
        }
        for(int i=1;i<s.length()-p.length()+1;i++){
            mem[s.charAt(i-1)-'a']++;
            mem[s.charAt(i+p.length()-1)-'a']--;
            if(isAnagram(mem)){
                result.add(i);
            }
        }
        return result;
    }
     static boolean  isAnagram(int[] mem ){
        for(int i=0;i< mem.length;i++){
            if(mem[i] != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("baa","aa"));
    }
}
