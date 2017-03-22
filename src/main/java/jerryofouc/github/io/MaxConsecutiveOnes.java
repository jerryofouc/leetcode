package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/21/17.
 */
public class MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null || nums.length==0){
            return 0;
        }
        int max = 0;
        boolean isLastOne = false;
        int currentCon = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1){
                if(!isLastOne){
                    currentCon = 1;
                    isLastOne = true;
                }else {
                    currentCon ++;
                }
                if(currentCon>max){
                    max = currentCon;
                }
            }else {
                isLastOne = false;
                currentCon = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
