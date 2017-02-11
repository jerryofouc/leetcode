package jerryofouc.github.io;

/**
 * Created by xiaojiez on 2/10/17.
 */
public class BurstBalloons {
    public  static  int maxCoins(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int[][] dp = new int[nums.length+1][nums.length];
        for(int i=0;i<nums.length;i++){
            if(i==0){
                dp[1][i] = nums[1]*nums[0];
            }else if(i == nums.length-1){
                dp[1][i] = nums[i]*nums[i-1];
            }else {
                dp[1][i] =nums[i+1]*nums[i]*nums[i-1];
            }
            dp[0][i] = 0;

        }
        for(int l = 2;l<nums.length+1;l++){
            for(int i=0;i<nums.length-l+1;i++){
                int max = Integer.MIN_VALUE;
                for(int j=i;j<i+l;j++){
                    int left = 0;
                    if(j>i){
                        left = dp[j-i][i];
                    }
                    int right = 0;
                    if(j<i+l-1){
                        right = dp[i+l-1-j][j+1];
                    }
                    int lc = 1;
                    if(i>0){
                        lc = nums[i-1];
                    }
                    int rc = 1;
                    if(i+l<nums.length){
                        rc = nums[i+l];
                    }
                    int center = nums[j]*lc*rc;
                    if(max < center+left+right){
                        max = center+left+right;
                    }
                }
                dp[l][i] =max;
            }
        }

        return dp[nums.length][0];
    }




    public static void main(String[] args) {
        int[] nums = new int[]{1,5};
        System.out.println(maxCoins(nums));
    }
}
