package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/22/17.
 */
public class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int s, int[] nums) {
        for(int i=1;i<nums.length;i++){
            nums[i] = nums[i-1]+nums[i];
        }

        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                int cur;
                if(j == i){
                    cur = nums[j];
                }else {
                    cur = nums[j]-nums[j-i-1];
                }
                if(cur>=s){
                    return i+1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] num = new int[]{2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,num));
    }
}
