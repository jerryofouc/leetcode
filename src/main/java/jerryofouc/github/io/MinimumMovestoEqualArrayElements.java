package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/16/17.
 */
public class MinimumMovestoEqualArrayElements {
    public int minMoves(int[] nums) {
        if(nums == null || nums.length<=1){
            return 0;
        }
        int min = nums[0];
        for(int i=1;i<nums.length;i++){
            if(min>nums[i]){
                min = nums[i];
            }
        }

        int result = 0;
        for(int i=0;i<nums.length;i++){
            result += nums[i] - min;
        }
        return result;
    }
}
