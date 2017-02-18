package jerryofouc.github.io;

/**
 * Created by xiaojiez on 2/17/17.
 */
public class CountOfRangeSum {
    public static int countRangeSum(int[] nums, int lower, int upper) {
        long[] sum = new long[nums.length+1];
        for(int i=0;i<nums.length;i++){
            sum[i+1] = sum[i] + nums[i];
        }

        return mergetSortCountRangeSum(sum,0,sum.length-1,lower,upper);
    }

    private static int mergetSortCountRangeSum(long[] sum, int s, int e, int lower, int upper) {
        if(e-s<1){
            return 0;
        }
        int mid = s + (e-s)/2;
        int left = mergetSortCountRangeSum(sum,s,mid,lower,upper);
        int right = mergetSortCountRangeSum(sum,mid+1,e,lower,upper);
        int j=mid+1,k = mid+1,t=mid+1;
        long[] cache = new long[e-s+1];
        int count = 0;
        int r=0;
        for(int i=s;r<cache.length&&i<=mid;){
            while (j<=e&&sum[j]-sum[i]<lower){
                j++;
            }
            while (k<=e&&sum[k] - sum[i]<=upper){
                k++;
            }
            while (t<=e&&sum[t]<sum[i]){
                cache[r++] = sum[t++];
            }
            cache[r++] = sum[i++];
            count += k-j;
        }

        System.arraycopy(cache,0,sum,s,r);


        return left+right+count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2147483647,0,-2147483647,2147483647};
        System.out.println(countRangeSum(nums,-564,3864));
    }


}
