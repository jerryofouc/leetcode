package jerryofouc.github.io;

/**
 * Created by xiaojiez on 2/20/17.
 */
public class IntegerBreak {
    public static int integerBreak(int n) {
        int[] dp = new int[n+10];
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;
        dp[5] = 6;
        dp[6] = 8;
        if(n<=6){
            return dp[n];
        }

        for(int i=7;i<=n;i++){
            int max = 2*dp[i-2];
            if(max<3*dp[i-3]){
                max =dp[i-3]*3;
            }
            dp[i] = max;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(5));
    }

}
