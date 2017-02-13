package jerryofouc.github.io;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaojiez on 2/12/17.
 */
public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        Map<Integer,Integer> mem = new HashMap<>();
        return coinChange(coins,amount,mem);
    }

    private static int coinChange(int[] coins, int amount, Map<Integer, Integer> mem) {
       if(mem.containsKey(amount)){
            return mem.get(amount);
       }
       if(amount == 0){
           return 0;
       }if(amount <0){
           return -1;
        }else {
           int min = Integer.MAX_VALUE;
           for(int i=0;i<coins.length;i++){
                int cur = coinChange(coins,amount-coins[i],mem);
                if(cur >=0 && cur+1<min ){
                    min = cur+1;
                }
           }
           if(min == Integer.MAX_VALUE){
               mem.put(amount,-1);
               return -1;
           }else {
               mem.put(amount,min);
               return min;
           }
       }
    }

    public static void main(String[] args) {
        int[] coins = new int[]{ 2, 5};
        System.out.println(coinChange(coins,3));
    }
}
