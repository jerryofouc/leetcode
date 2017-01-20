package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/20/17.
 */
public class RotateArray {
    public static void rotate(int[] nums, int k) {
        k = k%nums.length;
        int[] temp = new int[k];
        for(int i=nums.length-k;i<nums.length;i++){
            temp[i-(nums.length-k)] = nums[i];
        }
        for(int i=nums.length-k-1;i>=0;i--){
            nums[i+k] = nums[i];
        }
        for(int i=0;i<temp.length;i++){
            nums[i] = temp[i];
        }
    }
}
