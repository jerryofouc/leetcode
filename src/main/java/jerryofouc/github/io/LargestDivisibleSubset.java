package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiaojiez on 2/26/17.
 */
public class LargestDivisibleSubset {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int[] countArray = new int[nums.length];
        int[] lastIndex = new int[nums.length];
        int maxIndex = 0;
        int max = 0;
        for(int i=0;i<nums.length;i++){
            int last = -1;
            int maxCount = 0;
            for(int j=i-1;j>=0;j--){
                if(nums[i]%nums[j] == 0){
                    if(maxCount<countArray[j]){
                        maxCount = countArray[j];
                        last = j;
                    }
                }
            }
            lastIndex[i] = last;
            countArray[i] = maxCount+1;
            if(max < maxCount+1){
                max = maxCount+1;
                maxIndex = i;
            }
        }
        LinkedList<Integer> result = new LinkedList<>();
        while (maxIndex != -1){
            result.addFirst(nums[maxIndex]);
            maxIndex = lastIndex[maxIndex];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,4,8};
        System.out.println(largestDivisibleSubset(a));
    }
}
