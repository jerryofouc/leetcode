package jerryofouc.github.io;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaojiez on 2/7/17.
 */
public class BullsAndCows {
    public static String getHint(String secret, String guess) {
        if(secret==null || secret.length() == 0){
            return "0A0B";
        }
        Map<Character,Integer> secretMap = new HashMap<>();
        for(Character c : secret.toCharArray()){
            Integer i = secretMap.get(c);
            if(i == null){
                secretMap.put(c,1);
            }else {
                secretMap.put(c,i+1);
            }
        }
        int bull = 0;
        int cow = 0;
        for(int i=0;i<guess.length();i++){
            if(guess.charAt(i) == secret.charAt(i)){
                bull++;
                secretMap.put(guess.charAt(i),secretMap.get(guess.charAt(i))-1);
                if(secretMap.get(guess.charAt(i)) == 0){
                    secretMap.remove(guess.charAt(i));
                }
            }
        }
        for(int i=0;i<guess.length();i++){
            if(guess.charAt(i) != secret.charAt(i)){
                Integer count = secretMap.get(guess.charAt(i));
                if(count!=null&&count>0){
                    cow++;
                    count--;
                    secretMap.put(guess.charAt(i),count);
                }
            }
        }
        return bull+"A"+cow+"B";

    }

    public static void main(String[] args) {
        System.out.println(getHint("1","0"));
    }
}
