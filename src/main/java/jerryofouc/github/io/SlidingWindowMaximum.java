package jerryofouc.github.io;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by xiaojiez on 1/27/17.
 */
public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new int[]{};
        }
        int result[] = new int[nums.length-k+1];
        Deque<Integer> deque = new ArrayDeque<>();
        int count = 0;
        for(int i=0;i<nums.length;i++){
            while (!deque.isEmpty() && deque.peek()<i-k+1){
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()]<=nums[i]){
                deque.pollLast();
            }

            deque.offer(i);
            if(i>=k-1){
                result[count++] = nums[deque.peekFirst()];
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        maxSlidingWindow(nums,3);
    }
}
