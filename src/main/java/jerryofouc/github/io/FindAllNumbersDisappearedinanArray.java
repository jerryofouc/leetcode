package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaojiez on 3/14/17.
 */
public class FindAllNumbersDisappearedinanArray {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i] != i+1){
                int nextIndex = nums[i]-1;
                nums[i] = -i-1;
                while (nextIndex>=0&&nums[nextIndex] != nextIndex+1){
                    int temp = nextIndex+1;
                    nextIndex =nums[nextIndex]-1;
                    nums[temp-1] = temp;
                }

            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                result.add(i+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }
}
