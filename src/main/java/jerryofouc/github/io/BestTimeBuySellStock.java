package jerryofouc.github.io;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 3/15/14
 * Time: 0:10
 * To change this template use File | Settings | File Templates.
 */
public class BestTimeBuySellStock {
    public static int maxProfit(int[] prices) {
        if(prices.length == 0||prices.length==1){
            return 0;
        }
        int minArray[] = new int[prices.length];
        int min = prices[0];
        minArray[0] = min;
        int max = prices[prices.length - 1];
        for(int i=1;i<prices.length;i++){
            if(min > prices[i]){
                min = prices[i];
            }
            minArray[i] = min;
        }
        int retValue = max - minArray[prices.length-1];
        for(int i=prices.length-2;i>=0;i--){
            if(max < prices[i]){
                max = prices[i];
            }
            if(retValue < max - minArray[i]){
                retValue = max - minArray[i] ;
            }
        }
        if(retValue<0){
            return 0;
        }
        return retValue;
    }
    public static void main(String args[]){
        int[] a = {1,2};
        System.out.println(maxProfit(a));
    }
}
