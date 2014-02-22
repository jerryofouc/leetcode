package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 使用DP来做
 * User: zhangxiaojie
 * Date: 2/22/14
 * Time: 10:00
 * To change this template use File | Settings | File Templates.
 */
public class WordBreak {
    public static boolean wordBreak(String s, Set<String> dict){
        if(s==null||s.length() == 0){
            return true;
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
        return resultHash[0][s.length()-1];
    }



    public static void main(String args[]){
        Set<String> dict = new HashSet<String>();
        String[] words = {"leet","code"};
        for(String w : words){
            dict.add(w);
        }
        System.out.println(wordBreak("leetcode",dict));
    }
}
