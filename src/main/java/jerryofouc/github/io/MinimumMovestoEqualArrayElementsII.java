package jerryofouc.github.io;

import java.util.Arrays;

/**
 * Created by xiaojiez on 3/18/17.
 */
public class MinimumMovestoEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length-1;
        int result = 0;
        while (start<end){
            result += (nums[end--]-nums[start++]);
        }
        return result;
    }
}
