package jerryofouc.github.io;

/**
 * Created by xiaojiez on 2/7/17.
 */
public class NumArray {
    int sum[];
    public NumArray(int[] nums) {
        sum = new int[nums.length+1];
        sum[0] = 0;
        for(int i=1;i<nums.length+1;i++){
            sum[i] = sum[i-1] + nums[i-1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j+1]-sum[i];
    }

    public static void main(String[] args) {
        int num[] = new int[]{-2,0,3,-5,2,-1};
        NumArray numArray = new NumArray(num);
        System.out.println(numArray.sumRange(0,5));
    }
}
