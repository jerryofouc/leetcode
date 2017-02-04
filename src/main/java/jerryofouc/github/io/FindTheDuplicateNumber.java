package jerryofouc.github.io;

/**
 * Created by xiaojiez on 2/2/17.
 */
public class FindTheDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        return findDuplicate(1,nums.length-1,nums);
    }

    private static int findDuplicate(int s, int e, int[] nums) {
        int m = s + (e-s)/2;
        int small =0;
        int large = 0;
        int equal = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>m && nums[i]<=e){
                large++;
            }else if(nums[i]<m&&nums[i]>=s){
                small++;
            }else if(nums[i] == m){
                equal++;
            }
        }
        if(equal>1){
            return m;
        }
        if(small>m-s){
            return findDuplicate(s,m-1,nums);
        }else {
            return findDuplicate(m+1,e,nums);
        }
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1,4,4,2,4};
        System.out.println(findDuplicate(nums));
    }
}
