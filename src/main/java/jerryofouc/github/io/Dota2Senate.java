package jerryofouc.github.io;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by xiaojiez on 8/12/17.
 */
public class Dota2Senate {
    public static String predictPartyVictory(String senate) {
        LinkedList<Character> l = new LinkedList<>();
        for(char c : senate.toCharArray()){
            l.add(c);
        }
        int rc = 0;
        int dc = 0;
        while(true){
            int curRc = rc;
            int curDc = dc;
            Iterator<Character> iterator = l.iterator();
            while (iterator.hasNext()){
                char c = iterator.next();
                if(c == 'R'){
                    if(dc == 0){
                        rc ++;
                    }else {
                        iterator.remove();
                        dc--;
                    }
                }else {
                    if(rc == 0){
                        dc++;
                    }else {
                        iterator.remove();
                        rc--;
                    }
                }
            }
            if(curRc + l.size() == rc){
                return "Radiant";
            }
            if(curDc + l.size() == dc){
                return "RDD";
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(predictPartyVictory("RRDDD"));
    }
}
