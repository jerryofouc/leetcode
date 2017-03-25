package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xiaojiez on 3/25/17.
 */
public class LongestWordinDictionarythroughDeleting {
    public static String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()> o2.length()){
                    return -1;
                }else if(o1.length()<o2.length()){
                    return 1;
                }else {
                    return o1.compareTo(o2);
                }
            }
        });

        for(String a : d){
            if(isFormed(s,a,0,0)){
                return a;
            }
        }
        return "";
    }

    private static boolean isFormed(String s, String a, int i, int j) {
        if(j>=a.length()){
            return true;
        }
        if(i>=s.length()){
            return false;
        }
        if(s.charAt(i) == a.charAt(j)){
            return isFormed(s,a,i+1,j+1);
        }else {
            return isFormed(s,a,i+1,j);
        }
    }

    public static void main(String[] args) {
        List<String> d = new ArrayList<>();
        d.add("ale");
        d.add("apple");
        d.add("monkey");
        d.add("plea");
        System.out.println(findLongestWord("abpcplea",d));
    }


}
