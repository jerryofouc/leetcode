package jerryofouc.github.io;

/**
 * Created by xiaojiezhang on 1/4/17.
 *
 * 1.从后向前遍历,找到比当前数字大的比之前的都小的那个数字。
 * 2.如果找到,需要交换,然后再翻转后面的数组。
 * 3.需要注意,如果相等的情况,取最后面的哪一个。
 */
public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        if(nums.length <= 1){
            return;
        }
        boolean isFound = false;
        for(int i=nums.length-2;i>=0;i--){
            boolean mFound = false;
            int min = -1;
            for(int m = i+1;m<=nums.length-1;m++){
                if(nums[m] > nums[i]){
                    if(min == -1 || nums[m]<nums[min]){
                        min = m;
                    }
                    mFound = true;
                }
            }
            if(mFound){
                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
                isFound = true;
                int j = i+1,k = nums.length-1;
                while (j<k){
                    temp = nums[j];
                    nums[j] = nums[k];
                    nums[k] = temp;
                    j++;
                    k--;
                }
                break;
            }
        }

        if(!isFound){
            int i = 0,k = nums.length-1;
            while (i<=k){
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
                i++;
                k--;
            }
        }

    }

    public static void main(String[] args) {
        int num[] = new int[]{
                2,3,1
        };
        nextPermutation(num);
        for(int i=0;i<num.length;i++){
            System.out.println(num[i]);
        }

    }
}
