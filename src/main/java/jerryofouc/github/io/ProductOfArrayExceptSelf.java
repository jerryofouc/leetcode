package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/27/17.
 */
public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        long productAll = 1;
        for(int i=0;i<nums.length;i++){
            productAll *= nums[i];
        }

        int zeroNum = 0;



        if(productAll==0){
            for(int i=0;i<nums.length;i++){
                if(nums[i] == 0){
                    zeroNum++;
                }
            }
        }


        if(zeroNum == 1){
            int zeroIndex = -1;
            int allNotZeroProd = 1;
            for(int i=0;i<nums.length;i++){
                if(nums[i] == 0){
                    zeroIndex = i;
                }else {
                    allNotZeroProd *= nums[i];
                    nums[i] =0;
                }
            }
            nums[zeroIndex] = allNotZeroProd;
        }else if(zeroNum >1){
            for(int i=0;i<nums.length;i++){
                nums[i] =0;
            }
        }else {
            for(int i=0;i<nums.length;i++){
                nums[i] = (int )(productAll/nums[i]);
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,-1};
        System.out.println(productExceptSelf(nums));
    }
}
