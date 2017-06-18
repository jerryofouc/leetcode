package jerryofouc.github.io;

import java.util.Arrays;

/**
 * Created by xiaojiez on 6/11/17.
 */
public class ValidTriangleNumber {
    public static int triangleNumber(int[] nums) {
        if(nums.length<3){
            return 0;
        }
        Arrays.sort(nums);
        int k = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] <= 0){
                k++;
            }
        }
        int[] target = new int[nums.length-k];
        System.arraycopy(nums,k,target,0,target.length);
        nums = target;
        int total = nums.length*(nums.length-1)*(nums.length-2)/6;
        boolean isBreak = false;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int sum = nums[i]+nums[j];
                int p = Arrays.binarySearch(nums,j+1,nums.length,sum);
                if(p<0){
                    p = -(1+p);
                }
                while (p<nums.length&&p-1>j&&nums[p] == nums[p-1]){
                    p--;
                }
                if(p == nums.length){
                    if(j == i+1){
                        isBreak = true;
                    }
                    break;
                }
                int a = nums.length-p;
                total -= a;
            }
            if(isBreak){
                break;
            }
        }

        return total;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{82,15,23,82,67,0,3,92,11};
        System.out.println(triangleNumber(nums));
    }
}
