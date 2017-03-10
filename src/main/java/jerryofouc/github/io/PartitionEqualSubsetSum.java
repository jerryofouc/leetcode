package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/9/17.
 */
public class PartitionEqualSubsetSum {
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum %2 == 1){
            return false;
        }
        int target = sum/2;
        boolean[][]  dp = new boolean[nums.length+1][target+1];
        dp[0][0] = true;
        for(int i=1;i<=nums.length;i++){
            for(int j=1;j<=target;j++){
                boolean x = false;
                if(j-nums[i-1]>=0){
                    x = dp[i-1][j-nums[i-1]];
                }
                dp[i][j] = dp[i-1][j]||(x);
            }
        }
        return dp[nums.length][target];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 11, 5};
        System.out.println(canPartition(nums));
    }


}
