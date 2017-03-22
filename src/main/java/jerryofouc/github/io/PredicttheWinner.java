package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/22/17.
 */
public class PredicttheWinner {
    public static boolean PredictTheWinner(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        long[] sumArray = new long[nums.length+1];
        long sum = 0;
        sumArray[0] = sum;
        for(int i=1;i<=nums.length;i++){
            sum += nums[i-1];
            sumArray[i] = sum;
        }
        long[][] dp = new long[nums.length][nums.length];
        for(int i=0;i<nums.length;i++){
            dp[i][i] = nums[i];
        }
        for(int l = 2;l<=nums.length;l++){
            for(int i=0;i+l-1<nums.length;i++){
                dp[i][i+l-1] =
                        Math.max(nums[i]+sumArray[i+l]-sumArray[i+1]-dp[i+1][i+l-1],nums[i+l-1]+sumArray[i+l-1]-sumArray[i]-dp[i][i+l-2]);
            }
        }
        return dp[0][nums.length-1]>=(sumArray[nums.length]-sumArray[0]-dp[0][nums.length-1]);
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1, 5, 233, 7};
        System.out.println(PredictTheWinner(nums));
    }
}
