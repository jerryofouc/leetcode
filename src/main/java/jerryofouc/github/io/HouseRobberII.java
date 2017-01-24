package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/24/17.
 */
public class HouseRobberII {

    public int rob1(int[] nums) {
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

    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }

        int[] num1 = new int[nums.length-1];
        System.arraycopy(nums,1,num1,0,nums.length-1);
        int a = rob1(num1);
        int[] num2 = new int[nums.length-3];
        System.arraycopy(nums,2,num2,0,nums.length-3);
        int b = rob1(num2);
        return Math.max(a,b+nums[0]);
    }
}
