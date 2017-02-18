package jerryofouc.github.io;

/**
 * Created by xiaojiez on 2/18/17.
 */
public class PatchingArray {
    public int minPatches(int[] nums, int n) {
        long miss = 1,count = 0;
        int i = 0;
        while (miss<=n){
            if(i<nums.length&&nums[i]<=miss){
                miss += nums[i++];
            }else {
                miss += miss;
                count++;
            }
        }
        return (int)count;
    }
}
