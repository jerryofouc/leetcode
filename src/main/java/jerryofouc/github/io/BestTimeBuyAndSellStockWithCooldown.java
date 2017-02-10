package jerryofouc.github.io;

/**
 * Created by xiaojiez on 2/9/17.
 */
public class BestTimeBuyAndSellStockWithCooldown {
    public static int maxProfit(int[] prices) {
        if(prices==null || prices.length<=1){
            return 0;
        }
        int max[] = new int[prices.length];
        max[0] = 0;
        for(int i=1;i<prices.length;i++){
            int curMax = max[i-1];
            for(int k=i-1;k>=0;k--){
                int p = prices[i] - prices[k];
                int m;
                int t = k-2;
                if(t<=0){
                    m = 0;
                }else {
                    m = max[t];
                }
                if(curMax<p+m){
                    curMax = p+m;
                }
            }
            max[i] = curMax;
        }
        return max[max.length-1];
    }

    public static void main(String[] args) {
        int p[] = new int[]{1, 2, 3, 0, 2};
        System.out.println(maxProfit(p));
    }
}
