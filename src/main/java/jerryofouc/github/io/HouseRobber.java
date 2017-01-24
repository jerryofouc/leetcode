package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/20/17.
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;

        }        int[] mem = new int[nums.length+1];
        mem[nums.length] = 0;
        mem[nums.length-1] = nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            mem[i] = Math.max(nums[i]+mem[i+2],mem[i+1]);
        }
        return mem[0];
    }
}
