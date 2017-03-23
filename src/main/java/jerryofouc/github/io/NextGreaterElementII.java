package jerryofouc.github.io;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by xiaojiez on 3/23/17.
 */
public class NextGreaterElementII {
    public static int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0){
            return new int[]{};
        }

        Deque<Integer> deque = new LinkedList();
        for(int i=0;i<nums.length;i++){
            deque.add(nums[i]);
        }

        int[] result = new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            while (!deque.isEmpty()&&nums[i]>=deque.peekFirst()){
                deque.pollFirst();
            }
            if(deque.isEmpty()){
                result[i] = -1;
            }else {
                result[i] = deque.peekFirst();
            }
            deque.addFirst(nums[i]);
        }

        return result;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1};
        System.out.println(nextGreaterElements(nums));
    }
}
