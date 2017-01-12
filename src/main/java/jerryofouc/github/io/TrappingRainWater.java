package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/12/17.
 */
public class TrappingRainWater {
    public static int trap(int[] height) {
        if(height.length<=1){
            return 0;
        }
        int start = height[0];
        int result = 0;
        int temp = 0;
        for(int i=1;i<height.length;i++){
            if(height[i]<start){
                temp += start-height[i];
            }else {
                result += temp;
                temp = 0;
                start = height[i];
            }
        }

        start = height[height.length-1];
        temp = 0;
        for(int i=height.length-2;i>=0;i--){
            if(height[i]<=start){
                temp += start-height[i];
            }else if(height[i]>start){
                result += temp;
                temp = 0;
                start = height[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int nums[] = {2,0,2};
        System.out.println(trap(nums));
    }
}
