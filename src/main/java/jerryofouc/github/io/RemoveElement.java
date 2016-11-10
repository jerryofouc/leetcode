package jerryofouc.github.io;

/**
 * Created by xiaojiezhang on 11/9/16.
 */
public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int count = nums.length;
        int i = 0;
        int j = 0;
        while (j<nums.length){
            if(nums[j] == val){
                j++;
                count--;
            }else {
                nums[i++] = nums[j++];
            }
        }
        return count;

    }

}
