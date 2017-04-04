package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/26/17.
 */
public class RemoveBoxes {
    public static int removeBoxes(int[] boxes) {
        if(boxes.length == 0){
            return 0;
        }

        int[][][] dp = new int[boxes.length][boxes.length][boxes.length];
        return removeBoxes(0,boxes.length-1,0,boxes,dp);
    }

    private static int removeBoxes(int i, int j, int k, int[] boxes, int[][][] dp) {
        if(i>j){
            return 0;
        }
        if(dp[i][j][k] != 0){
            return dp[i][j][k];
        }
        if(i == j){
            return (k+1)*(k+1);
        }
        int max = (k+1)*(k+1) + removeBoxes(i+1,j,0,boxes,dp);
        for(int t = i+1;t<=j;t++){
            if(boxes[t] == boxes[i]){
                int cur = removeBoxes(i+1,t-1,0,boxes,dp) + removeBoxes(t,j,k+1,boxes,dp);
                max = Math.max(max,cur);
            }
        }
        dp[i][j][k] = max;
        return max;
    }


    public static void main(String[] args) {
        int[] a = new int[]{1,2};
        System.out.println(removeBoxes(a));
    }

}
