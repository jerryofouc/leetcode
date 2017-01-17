package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/17/17.
 */
public class FindPeakElement {
    public static int findPeakElement(int[] nums) {
        if(nums.length == 1){
            return 0;
        }

        if(nums[0]>nums[1]){
            return  0;
        }

        if(nums[nums.length-1]>nums[nums.length-2]){
            return nums.length-1;
        }



        for(int i=1;i<nums.length-1;i++){
            int pre = nums[i-1];
            int after = nums[i+1];
            if(pre<nums[i] && after< nums[i]){
                return i;
            }
        }
        return 0;
    }
}
