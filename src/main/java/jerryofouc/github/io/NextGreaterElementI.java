package jerryofouc.github.io;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by xiaojiez on 3/23/17.
 */
public class NextGreaterElementI {
    public static int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        Deque<Integer> integerDeque = new LinkedList<>();
        for(int i=nums.length-1;i>=0;i--){
            while (!integerDeque.isEmpty()&&nums[i]>integerDeque.peekFirst()){
                integerDeque.pollFirst();
            }
            if(integerDeque.isEmpty()){
                map.put(nums[i],-1);
            }else {
                map.put(nums[i],integerDeque.peekFirst());
            }
            integerDeque.addFirst(nums[i]);
        }

        int[] next = new int[findNums.length];
        for(int i=0;i<next.length;i++){
            next[i] = map.get(findNums[i]);
        }
        return next;
    }

    public static void main(String[] args) {
        int[] findNums = {4,1,2};
        int[] nums = {1,3,4,2};
        System.out.println(nextGreaterElement(findNums,nums));
    }


}
