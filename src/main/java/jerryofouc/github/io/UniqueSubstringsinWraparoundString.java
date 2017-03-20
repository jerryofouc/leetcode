package jerryofouc.github.io;

import java.util.*;

/**
 * Created by xiaojiez on 3/19/17.
 */
public class UniqueSubstringsinWraparoundString {
    public static int findSubstringInWraproundString(String p) {
        if(p == null){
            return 0;
        }
        if(p.length() <=1){
            return p.length();
        }
        int last = p.charAt(0);
        int curLen = 1;
        Set<String> set = new HashSet<>();
        for(int i=1;i<p.length();i++){
            if((last + 1-'a')%26 == (p.charAt(i)-'a')){
                curLen++;
            }else {
                set.add(p.substring(i-curLen,i));
                curLen = 1;
            }
            last = p.charAt(i);
        }

        set.add(p.substring(p.length()-curLen,p.length()));



        String maxString = "";
        for(String a : set){
            if(a.length()>maxString.length()){
                maxString = a;
            }
        }

        Map<Integer,HashSet<Character>> map = new HashMap<>();
        HashSet<Character> full = new HashSet<>();
        for(char i = 'a' ;i<='z';i++){
            full.add(i);
        }

        for(int l=maxString.length();l>=1;l--){
            if(maxString.length()-26>=l-1){
                map.put(l,full);
            }else {
                HashSet<Character> set1 = new HashSet<>();
                for(int i=0;i+l<=maxString.length();i++){
                        set1.add(maxString.charAt(i));
                        map.put(l,set1);
                }
            }
        }


        for(String a : set){
            if(!a.equals(maxString)){
                for(int l = a.length();l>=1;l--){
                    HashSet<Character> set1 = map.get(l);
                    if(set1.size()==26){
                        break;
                    }else {
                        for(int i=0;i+l<=a.length();i++){
                            set1.add(a.charAt(i));
                            map.put(l,set1);
                        }
                    }
                }
            }
        }
        int result = 0;
        for(Map.Entry<Integer,HashSet<Character>> entry : map.entrySet()){
            result += entry.getValue().size();
        }
        return result;

    }


    public static void main(String[] args) {
        case2();
    }

    static void case2(){
        System.out.println(findSubstringInWraproundString("zab"));
    }

    static void case1(){
        System.out.println(findSubstringInWraproundString("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));
    }


}
