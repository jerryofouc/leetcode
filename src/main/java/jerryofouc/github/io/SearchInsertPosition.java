package jerryofouc.github.io;

/**
 * Created by xiaojiezhang on 1/5/17.
 * 找到插入位置
 * 1.也是要经过二分查找
 * 2.观察最后的状态肯定是start=end-1,start只为正值,target肯定>start <start+1那个值,所以插入地方必然为start
 *
 */
public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        return searchInsert(nums,0,nums.length-1,target);
    }

    private static int searchInsert(int[] nums, int start, int end, int target) {
        while (start<=end){
            int middleIndex = (start+end)/2;
            int m = nums[middleIndex];
            if(m == target){
                return middleIndex;
            }else if(target>m){
                start  = middleIndex+1;
            }else {
                end = middleIndex -1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,5};
        int result = searchInsert(nums,0);
        System.out.println(result);
    }
}
