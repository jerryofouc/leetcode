package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/31/17.
 */
public class SingleNumberIII {
    public static int[] singleNumber(int[] nums) {
        int xorResult = 0;
        for(int i=0;i<nums.length;i++){
            xorResult ^= nums[i];
        }

        int k = 1;
        while ((xorResult & k)==0){
            k = (k<<1);
        }

        int result[] = new int[2];
        for(int i=0;i<nums.length;i++){
            if((nums[i] & k) ==0){
                result[0] ^= nums[i];
            }else {
                result[1] ^= nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1,3,2,5};
        System.out.println(singleNumber(nums));
    }
}
