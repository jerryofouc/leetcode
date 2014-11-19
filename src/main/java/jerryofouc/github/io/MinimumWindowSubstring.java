package jerryofouc.github.io;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangxiaojie
 *         2014-11-16 00:03
 *         功能介绍:
 */
public class MinimumWindowSubstring {

    public static void main(String args[]){
        System.out.println(minWindow("bba","ab"));
    }
    public static String minWindow(String S, String T) {
        char[] sc = S.toCharArray();
        char[] tc = T.toCharArray();

        final int tsize = tc.length;
        Map<Character,Integer> tCountMap = new HashMap<Character,Integer>();

        for(int i=0;i<tc.length;i++){
            if(!tCountMap.containsKey(tc[i])){
                tCountMap.put(tc[i],1);
            }else {
                tCountMap.put(tc[i],tCountMap.get(tc[i])+1);
            }
        }

        Map<Character,Integer> currentMap = new HashMap<Character, Integer>();
        for(Character c : tCountMap.keySet()){
            currentMap.put(c,0);
        }

        int minBegin = -1;
        int minEnd = -1;
        int begin = -1;
        int end = -1;
        int count = 0;

        for(int i=0;i<sc.length;i++){
            char c = sc[i];
            if(currentMap.containsKey(c)){
                if(begin == -1){
                    begin = i;
                }
                int curCount = currentMap.get(c);
                int needCount = tCountMap.get(c);
                if(curCount < needCount){
                    currentMap.put(c,++curCount);
                    if(++count == tsize){
                        end = i;
                        if(minBegin == -1){
                            minBegin = begin;
                            minEnd = end;
                        }
                    }
                }else {
                    currentMap.put(c,++curCount);
                }

                if(count>=tsize){
                    while(currentMap.containsKey(sc[begin]) && currentMap.get(sc[begin])>tCountMap.get(sc[begin])
                            || !currentMap.containsKey(sc[begin])){
                        if(currentMap.containsKey(sc[begin]) && currentMap.get(sc[begin])>tCountMap.get(sc[begin])){
                            currentMap.put(sc[begin],currentMap.get(sc[begin])-1);
                        }
                        begin++;
                    }
                    end = i;

                    if(end-begin<minEnd-minBegin){
                        minEnd = end;
                        minBegin = begin;
                    }
                }
            }
        }
        if(minBegin == -1){
            return "";
        }else {
            return S.substring(minBegin,minEnd+1);
        }
    }
}
