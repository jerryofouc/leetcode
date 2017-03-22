package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/22/17.
 */
public class ReversePairs {

    public static int reversePairs(int[] nums) {
        if(nums == null || nums.length <= 1){
            return 0;
        }
        return mergeSort(nums,0,nums.length-1);
    }

    private static int mergeSort(int[] nums, int start, int end) {
        if(start == end){
            return 0;
        }
        int mid = start + (end-start)/2;
        int a = mergeSort(nums,start,mid);
        int b = mergeSort(nums,mid+1,end);
        int j = mid;
        int i=end;
        int sum = 0;
        while (j>=start){
            sum += end-i;
            while (i>mid&&(long)nums[j]>((long)(nums[i]))*2){
                i--;
                sum++;
            }
            j--;
        }

        int[] temp = new int[end-start+1];
        i=start;
        j=mid+1;
        int k = 0;
        while (i<=mid&&j<=end){
            if(nums[i]>=nums[j]){
                temp[k++] = nums[i++];
            }else {
                temp[k++] = nums[j++];
            }
        }
        while (i<=mid){
            temp[k++] = nums[i++];
        }
        while (j<=end){
            temp[k++] = nums[j++];
        }
        System.arraycopy(temp,0,nums,start,end-start+1);
        return sum+a+b;
    }


    public static void main(String[] args) {
        int[] a = new int[]{2147483647,2147483647,-2147483647,-2147483647,-2147483647,2147483647};
        System.out.println(reversePairs(a));
    }
}
