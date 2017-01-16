package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/15/17.
 */
public class JumpGame {
    public static boolean canJump(int[] nums) {
        if(nums.length==1){
            return true;
        }
        int curJumpLength = nums[0];
        if(curJumpLength == 0){
            return false;
        }
        if(curJumpLength>=nums.length-1){
            return true;
        }
        int i=1;
        while (i<nums.length){
            int nexJumpLength = curJumpLength;
            for(;i<nums.length&&i<=curJumpLength;i++){
                if(nums[i]+i>nexJumpLength){
                    nexJumpLength = nums[i]+i;
                }
            }
            if(nexJumpLength == curJumpLength){
                return false;
            }
            curJumpLength = nexJumpLength;
            if(curJumpLength>=nums.length-1){
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,0,4};
        System.out.println(canJump(nums));
    }
}
