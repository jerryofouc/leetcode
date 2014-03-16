package jerryofouc.github.io;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 3/15/14
 * Time: 0:56
 * To change this template use File | Settings | File Templates.
 */
public class BestTimeBuySellStockII {
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices.length == 1){
            return 0;
        }
        int max =0;
        for(int i=0;i<prices.length-1;i++){
           if(prices[i+1] - prices[i]>0){
               max +=  prices[i+1] - prices[i];
           }
        }
        return max;
    }
}
