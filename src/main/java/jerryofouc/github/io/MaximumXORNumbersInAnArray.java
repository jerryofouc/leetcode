package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/10/17.
 */

import java.util.HashSet;

/**
 * x^y = z
 * z^x = y
 * z^y = x
 */
public class MaximumXORNumbersInAnArray {
    public static int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;
        for(int i=30;i>=0;i--){
            mask = mask | (1<<i);
            HashSet<Integer> set = new HashSet<>();
            for(int j=0;j<nums.length;j++){
                set.add(nums[j]&mask);
            }
            int temp = max |(1<<i);
            for(Integer prefix:set){
                if(set.contains(prefix^temp)){
                    max = temp;
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{14,70,53,83,49,91,36,80,92,51,66,70};
        System.out.println(findMaximumXOR(nums));
    }


}
