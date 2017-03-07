package jerryofouc.github.io;

import java.util.*;

/**
 * Created by xiaojiez on 3/4/17.
 */
public class RandomPickIndex {
    private Map<Integer,List<Integer>> map ;
    public RandomPickIndex(int[] nums) {
        map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            List<Integer> list = map.get(nums[i]);
            if(list == null){
                list = new ArrayList<>();
            }
            list.add(i);
            map.put(nums[i],list);
        }

    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        return list.get(new Random().nextInt(list.size()));
    }
}
