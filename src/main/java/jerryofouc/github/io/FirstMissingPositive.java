package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/11/17.
 * 思路：
 * 利用数组的下标做文章
 */
public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int a = nums[i];
            if(a>0){
                if(a<=nums.length){
                    if(a-1<i){
                        nums[a-1] = a;
                    }else if(a-1>i){
                        int temp = nums[a-1];
                        nums[a-1] = a;
                        while (temp>0&&temp<=nums.length&&temp-1>i){
                            int temp1 = nums[temp-1];
                            nums[temp-1] = temp;
                            temp = temp1;
                            if(temp-1>0&&temp == nums[temp-1]){
                                break;
                            }
                        }
                        if(temp>0&&temp<=nums.length&&temp - 1 <= i){
                            nums[temp-1] = temp;
                        }
                    }
                }
            }
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,0};
        System.out.println(firstMissingPositive(nums));
    }
}
