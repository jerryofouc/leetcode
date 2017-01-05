package jerryofouc.github.io;

/**
 * Created by xiaojiezhang on 1/5/17.
 */
public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        return search(nums,0,nums.length-1,target);
    }
    public static int search(int[] nums,int start,int end,int target){
        if(start>end){
            return -1;
        }
        int middleIndex = (start+end)/2;
        int m = nums[middleIndex];
        if(m == target){
            return middleIndex;
        }
        if(target == nums[start]){
            return start;
        }
        if(target == nums[end]){
            return end;
        }
        if(nums[start]<nums[end]){
            return binarySearch(nums,start,end,target);
        }
        if(nums[start]<m){
            if(target>nums[start] && target <m){
                return binarySearch(nums,start,middleIndex-1,target);
            }else {
                return search(nums,middleIndex+1,end,target);
            }
        }else {
            if(target>m && target<nums[start]){
                return binarySearch(nums,middleIndex+1,end,target);
            }else {
                return search(nums,start,middleIndex-1,target);
            }
        }

    }

    private static int binarySearch(int[] nums, int start, int end, int target) {
        while (start<=end){
            int middleIndex = (start+end)/2;
            int m = nums[middleIndex];
            if(m == target){
                return middleIndex;
            }
            if(target>m){
                start = middleIndex + 1;
            }else {
                end = middleIndex-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4 ,5 ,6, 7, 0, 1, 2};
        System.out.println(search(nums,7));
    }
}
