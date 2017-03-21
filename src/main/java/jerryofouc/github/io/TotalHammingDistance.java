package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/21/17.
 */
public class TotalHammingDistance {
    public static int totalHammingDistance(int[] nums) {
        int sum = 0;
        for(int i=0;i<32;i++){
            int zeroSum = 0;
            int oneSum = 0;
            for(int j=0;j<nums.length;j++){
                if((nums[j]&(1<<i) )!=0){
                    oneSum++;
                }else {
                    zeroSum++;
                }
            }
            sum+=zeroSum*oneSum;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 14, 2};
        System.out.println(totalHammingDistance(nums));
    }
}
