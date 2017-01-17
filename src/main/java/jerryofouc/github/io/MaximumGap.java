package jerryofouc.github.io;


import java.util.Arrays;
import java.util.BitSet;

/**
 * Created by xiaojiez on 1/17/17.
 */
public class MaximumGap {
    public  static int maximumGap(int[] nums) {
        if(nums.length<2){
            return 0;
        }
        if(nums.length<10000){
            Arrays.sort(nums);
            int max = 0;
            for(int i=0;i<nums.length-1;i++){
                if(nums[i+1] - nums[i]>max){
                    max = nums[i+1]-nums[i];
                }
            }
            return max;
        }


        BitSet bitSet = new BitSet(Integer.MAX_VALUE);
        for(int i=0;i<nums.length;i++){
            bitSet.set(nums[i],true);
        }

        int first = -1;
        int maxGap = 0;
        for(int i=0;i<Integer.MAX_VALUE;i++){
            if(bitSet.get(i)){
                if(first != -1 && maxGap < i-first){
                    maxGap = i-first;
                }
                first=i;
            }
        }

        return maxGap;
    }

    public static void main(String[] args) {
        int num[] = new int[]{1,10000000};
        System.out.println(maximumGap(num));
    }


}
