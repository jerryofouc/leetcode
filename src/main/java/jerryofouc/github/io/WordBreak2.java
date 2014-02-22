package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 2/22/14
 * Time: 12:07
 * To change this template use File | Settings | File Templates.
 */
public class WordBreak2 {
    public static ArrayList<String> wordBreak(String s, Set<String> dict) {
        if(s==null||s.length() == 0){
            return new ArrayList<String>();
        }
        boolean[][] resultHash = new boolean[s.length()][s.length()];
        for(int len = 0;len<s.length();len++){
            for(int i=0;i<s.length();i++){
                if(i+len<s.length()){
                    if(dict.contains(s.substring(i,i+len+1))){
                        resultHash[i][len] = true;
                    }else{
                        for(int k=i;k<i+len;k++){
                            if(resultHash[i][k-i] && resultHash[k+1][len-(k-i)-1]){
                                resultHash[i][len] = true;
                            }
                        }
                    }
                }
            }
        }

        return new ArrayList<String>(wordBreak(0,s,resultHash,dict));
    }

    private static Set<String> wordBreak(int start,String s, boolean[][] resultHash,Set<String> dict) {
        Set<String> result = new HashSet<String>();
        if(s == null||s.length()==0){
            result.add("");
            return result;
        }
        for(int i=0;i<s.length();i++){
            if( dict.contains(s.substring(0,i+1)) && (s.substring(i+1,s.length()).length()==0 || resultHash[start+i+1][s.length()-i-2])){
                Set<String> sa = wordBreak(start+i+1,s.substring(i+1,s.length()),resultHash,dict);
                for(String t : sa){
                    if(t != null && t.length()!=0){
                        result.add(s.substring(0,i+1) + " " + t);
                    }else{
                        result.add(s.substring(0,i+1));
                    }
                }
            }
        }
        return result;
    }

    public static void main(String args[]){
        Set<String> dict = new HashSet<String>();
        String[] words = {"a"};
        for(String w : words){
            dict.add(w);
        }
        for(String s : wordBreak("a",dict)){
            System.out.println(s);
        }
    }
}
