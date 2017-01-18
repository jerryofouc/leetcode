package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/18/17.
 */
public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int m =nums[0];
        int sum = 1;
        for(int i=1;i<nums.length;i++){
            if(sum == 0){
                sum = 1;
                m = nums[i];
            }else {
                if(m == nums[i]){
                    sum++;
                }else {
                    sum--;
                }
            }
        }
        return m;
    }
}
