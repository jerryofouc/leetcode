package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/24/17.
 * QuickSelect
 */
public class KthLargestElementInAnArray {
    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(k,0,nums.length-1,nums);
    }

    private static int quickSelect(int k, int start, int end, int[] nums) {
        if(start == end){
            return nums[start];
        }
        int pivot = nums[end];
        int i=start;
        for(int j=start;j<end;j++){
            if(nums[j]<=pivot){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
        }
        int temp = nums[end];
        nums[end] = nums[i];
        nums[i] = temp;

        if(i == nums.length-k){
            return nums[i];
        }else if(i<nums.length-k){
            return quickSelect(k,i+1,end,nums);
        }else {
            return quickSelect(k,start,i-1,nums);
        }
    }

    public static void main(String[] args) {
        int[] num = new int[]{-1,-1};
        System.out.println(findKthLargest(num, 2));
    }
}
