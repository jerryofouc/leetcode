package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/9/17.
 */
public class SplitArrayLargestSum {
    public static int splitArray(int[] nums, int m) {
        int [][] mem = new int[nums.length][m+1];
        int[] sum = new int[nums.length+1];
        sum[0] = 0;
        for(int i=0;i<nums.length;i++){
            sum[i+1] = sum[i] + nums[i];
        }

        for(int i=0;i<mem.length;i++){
            mem[i][1] = sum[i+1];
        }

        for(int i=2;i<=m;i++){
            for(int j=i-1;j<nums.length;j++){
                int max = Integer.MAX_VALUE;
                for(int k=0;k<j;k++){
                    max = Math.min(max,Math.max(mem[k][i-1],sum[j+1]-sum[k+1]));
                }
                mem[j][i] = max;
            }
        }
        return mem[nums.length-1][m];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,2,5,10,8};
        System.out.println(splitArray(nums,2));
    }
}
