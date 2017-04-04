package jerryofouc.github.io;

/**
 * Created by xiaojiez on 4/2/17.
 */
public class SplitArraywithEqualSum {
    public static boolean splitArray(int[] nums) {
        if(nums.length <7){
            return false;
        }
        int[] sumArray = new int[nums.length+1];
        sumArray[0] = 0;
        int sum = 0;
        for(int i=1;i<sumArray.length;i++){
            sum += nums[i-1];
            sumArray[i] = sum;
        }

        for(int i=0;i<nums.length;i++){
            for(int j=nums.length-1;j-i>=6;j--){
                int sumS = sumArray[i+1]-sumArray[0];
                int sumE = sumArray[nums.length]-sumArray[j];
                if(sumS == sumE){
                    for(int k = i+3;k<j-1;k++){
                        if(sumArray[k]-sumArray[i+2] == sumArray[j-1]-sumArray[k+1] && sumArray[j-1]-sumArray[k+1] == sumE){
                            return true;
                        }
                    }

                }
            }
        }
        return false;

    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1,2,1,2,1};
        System.out.println(splitArray(nums));
    }
}
