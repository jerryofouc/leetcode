package jerryofouc.github.io;

import java.util.Arrays;

/**
 * Created by xiaojiez on 4/23/17.
 */
public class ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for(int i=0;i<nums.length/2;i++){
            result += nums[i*2];
        }
        return result;
    }
}
