package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/14/17.
 * key observation:当第n步能够到达K节点时，则对于k<K都会在<=n步的时候到达
 */
public class JumpGameII {
    public static int jump(int[] nums) {
        if(nums.length<2){
            return 0;
        }
        int currentMaxJump = 0,i=0,count = 0;
        while (i< nums.length){
            count++;
            int nexMaxJump = currentMaxJump;
            for(;i<=currentMaxJump;i++){
                nexMaxJump = Math.max(nexMaxJump,nums[i]+i);
                if(nexMaxJump>=nums.length-1){
                    return count;
                }
            }
            currentMaxJump = nexMaxJump;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(jump(nums));
    }
}
