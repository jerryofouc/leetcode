package jerryofouc.github.io;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaojiezhang on 11/2/16.
 */
public class RomanToInteger {
    public static int romanToInt(String s) {
        int retValue = 0;
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        char[] romanChars = s.toCharArray();
        for(int i=0;i<romanChars.length;){
            char first = romanChars[i];
            if(i+1 == romanChars.length){
                retValue += map.get(first+"");
                break;
            }else {
                char second = romanChars[i+1];
                if(second == first){
                    if(i+2 == romanChars.length){
                        retValue += 2*map.get(first+"");
                        break;
                    }
                    if(romanChars[i+2] == first){
                        retValue += 3*map.get(first+"");
                        i = i+3;
                    }else {
                        retValue += 2*map.get(first+"");
                        i = i+2;
                    }
                }else if(map.get(second+"")>map.get(first+"")){
                    retValue += map.get(second+"")-map.get(first+"");
                    i = i+2;
                }else{
                    retValue += map.get(first+"");
                    i = i+1;
                }
            }
        }
        return retValue;

    }
    public static void main(String[] args) {
        System.out.println(romanToInt("MMMDLXXXVI"));
    }
}
