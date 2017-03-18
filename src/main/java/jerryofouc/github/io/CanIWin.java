package jerryofouc.github.io;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaojiez on 3/18/17.
 */
public class CanIWin {
    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if((1+maxChoosableInteger)*maxChoosableInteger/2<desiredTotal){
            return false;
        }
        if(maxChoosableInteger >= desiredTotal){
            return true;
        }
        Map<Integer,Boolean> map = new HashMap<>();
        return canIWin(map,(1<<maxChoosableInteger)-1,maxChoosableInteger,desiredTotal);
    }

    private static boolean canIWin(Map<Integer, Boolean> map, int k, int maxChoosableInteger,int desiredTotal) {
        if(desiredTotal <= 0){
            return false;
        }
        if(map.containsKey(k)){
            return map.get(k);
        }
        for(int i=0;i<maxChoosableInteger;i++){
            int index = (1<<i);
            if((index&k) != 0){
                int nextIndex = ((0xFFFFFFFF)^index)&k;
                if(canIWin(map,nextIndex,maxChoosableInteger,desiredTotal-(maxChoosableInteger-i))){
                    map.put(nextIndex,true);
                }else {
                    map.put(k,true);
                    return true;
                }
            }
        }
        map.put(k,false);
        return false;
    }


    public static void main(String[] args) {
        System.out.println(canIWin(4,6));
    }
}
