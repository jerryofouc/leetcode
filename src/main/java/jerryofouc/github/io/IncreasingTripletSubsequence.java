package jerryofouc.github.io;

/**
 * Created by xiaojiez on 2/19/17.
 */
public class IncreasingTripletSubsequence {
    public static boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length<3){
            return false;
        }

        int min = nums[0];
        int[] array = new int[2];
        array[0] = min;
        int state = 1;
        for(int i=1;i<nums.length;i++){
            if(state == 1){
                if(nums[i]>min){
                    array[1] = nums[i];
                    state = 2;
                }else {
                    min = nums[i];
                    array[0] = nums[i];
                }
            }else if(state == 2){
                if(nums[i]>array[1]){
                    return true;
                }else if(nums[i]>array[0] && nums[i]<array[1]){
                    array[1] = nums[i];
                }else if(nums[i]<array[0]){
                    min = nums[i];
                    state = 3;
                }
            }else if(state == 3){
                if(nums[i]>array[1]){
                    return true;
                }else if(nums[i]<min){
                    min = nums[i];
                }else {
                    array[0] = min;
                    array[1] = nums[i];
                    state = 2;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1, 2, 3, 4, 5};
        System.out.println(increasingTriplet(nums));
    }
}
