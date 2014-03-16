package jerryofouc.github.io;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 3/15/14
 * Time: 1:08
 * To change this template use File | Settings | File Templates.
 */
public class BestTimeBuySellStockIII {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }

        int valley = prices[0];
        int peak = prices[prices.length - 1];

        int[] history = new int[prices.length];
        int[] future = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            valley = min(prices[i], valley);
            if (i > 0) {
                history[i] = max(history[i - 1], prices[i] - valley);
            }
        }

        int ret = history[prices.length - 1];
        for (int i = prices.length - 1; i >= 0; i--) {
            peak = max(peak, prices[i]);
            if (i < prices.length - 1) {
                future[i] = max(future[i + 1], peak - prices[i]);
                if (ret < history[i] + future[i + 1]) {
                    ret = history[i] + future[i + 1];
                }
            }
        }

        return ret;
    }

    static int max(int a, int b) {
        return a > b ? a : b;
    }

    static int min(int a, int b) {
        return a < b ? a : b;
    }

    public static void main(String args[]) {
        int[] test = {3, 2, 6, 5, 0, 3};
        System.out.println(maxProfit(test));
    }


}
