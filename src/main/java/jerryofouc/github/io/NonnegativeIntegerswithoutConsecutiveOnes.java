package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaojiez on 5/29/17.
 */
public class NonnegativeIntegerswithoutConsecutiveOnes {
    public static int findIntegers(int num) {
        List<Integer> binaryList = new ArrayList<>();
        while (num/2 != 0){
            binaryList.add(num%2);
            num = num/2;
        }
        binaryList.add(num);
        int nums[] = new int[binaryList.size()];
        for(int i=0;i<binaryList.size();i++){
            nums[i] = binaryList.get(nums.length-i-1);
        }

        int[] a = new int[nums.length+1];
        a[0] = 1;
        a[1] = 2;
        for(int i=2;i<nums.length+1;i++){
            a[i] = a[i-2]+a[i-1];
        }
        int sum = 0;
        boolean shouldBreak = false;
        for(int i=0;i<nums.length;i++){
            int last = 0;
            for(int j=0;j<=i;j++){
                if(last == 1 && nums[j] == 1){
                    shouldBreak = true;
                    break;
                }
                last = nums[j];
            }
            if(nums[i] == 1){
                sum += a[nums.length-i-1];
            }
            if(shouldBreak){
                break;
            }
        }
        if(!shouldBreak){
            sum++;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(findIntegers(3));
    }
}
