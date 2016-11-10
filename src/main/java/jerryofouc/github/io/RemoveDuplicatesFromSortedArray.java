package jerryofouc.github.io;

/**
 * Created by xiaojiezhang on 11/9/16.
 */
public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int i = 0;
        int j = 1;
        int count = 1;
        while(j<nums.length){
            if(nums[j] == nums[i]){
                j++;
            }else {
                nums[++i] = nums[j++];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
            1,1,2,2,3,4
        };
        System.out.println(removeDuplicates(nums));
    }
}
