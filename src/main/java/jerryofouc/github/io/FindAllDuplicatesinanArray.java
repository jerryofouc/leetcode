package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaojiez on 3/13/17.
 */
public class FindAllDuplicatesinanArray {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i] != i+1){
                int next = nums[i];
                nums[i] = -(i+1);
                int temp = nums[next-1];
                while (temp>0&&temp != next){
                    nums[next-1] = next;
                    next = temp;
                    temp = nums[next-1];
                }
                if(temp>0){
                    result.add(temp);
                }else {
                    nums[-temp-1] = -temp;
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,2,5,10,9,1,1,4,3,7};
        System.out.println(findDuplicates(nums));
    }
}
