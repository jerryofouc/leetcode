package jerryofouc.github.io;

import java.util.TreeSet;

/**
 * Created by xiaojiez on 3/9/17.
 */
public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            if(treeSet.size() <3){
                treeSet.add(nums[i]);
            }else {
                if(nums[i]>treeSet.first()){
                    treeSet.add(nums[i]);
                    if(treeSet.size()!=3){
                        treeSet.remove(treeSet.first());
                    }
                }
            }
        }
        if(treeSet.size()==3){
            return treeSet.first();
        }else {
            return treeSet.last();
        }

    }
}
