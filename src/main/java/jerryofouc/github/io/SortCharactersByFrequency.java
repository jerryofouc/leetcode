package jerryofouc.github.io;

import java.util.*;

/**
 * Created by xiaojiez on 3/15/17.
 */
public class SortCharactersByFrequency {
     static class Pair{
         char a;
         StringBuilder aa;

         public Pair(char a, StringBuilder aa) {
             this.a = a;
             this.aa = aa;
         }
     }
    public static String frequencySort(String s) {
        TreeMap<Character,StringBuilder> map = new TreeMap<>();
        for(int i=0;i<s.length();i++){
            char a = s.charAt(i);
            StringBuilder num =  map.get(a);
            if(num == null){
                num=new StringBuilder();
            }
            map.put(a,num.append(a));
        }
        String result = "";
        List<Pair> pairList = new ArrayList<>();
        for(Map.Entry<Character,StringBuilder> entry : map.entrySet()){
            pairList.add(new Pair(entry.getKey(),entry.getValue()));
        }
        Collections.sort(pairList, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.aa.length() > o2.aa.length()){
                    return -1;
                }else if(o1.aa.length() < o2.aa.length()){
                    return 1;
                }else {
                    return 0;
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        for(Pair p : pairList){
            sb.append(p.aa);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }
}
