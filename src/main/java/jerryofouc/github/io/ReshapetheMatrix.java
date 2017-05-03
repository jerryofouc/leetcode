package jerryofouc.github.io;

/**
 * Created by xiaojiez on 5/3/17.
 */
public class ReshapetheMatrix {
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums.length==0){
            return nums;
        }
        if(nums.length*nums[0].length != r*c){
            return nums;
        }

        int[][] result = new int[r][c];

        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                result[(i*nums[0].length+j)/c][((i*nums[0].length+j)%c)] = nums[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,2},{3,4}};
        System.out.println(matrixReshape(nums,1,4));
    }
}
