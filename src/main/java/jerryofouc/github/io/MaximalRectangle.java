package jerryofouc.github.io;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 5/8/14
 * Time: 21:32
 * To change this template use File | Settings | File Templates.
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        int rowNum = matrix.length;
        int culNum = matrix[0].length;
        if(culNum == 0){
            return 0;
        }
        int max = 0;
        int[] dp = new int[culNum];
        for(int r = 0;r<rowNum;r++){
            for(int c = 0;c<culNum;c++){
               dp[c] = matrix[r][c] == '0' ? 0 : (dp[c] + (matrix[r][c] - '0'));
            }
            max = Math.max(max,getMax(dp));
        }
        return max;
    }

    private int getMax(int[] dp) {
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for(int i=0;i<dp.length;i++){
            int nstop = 0;
            while(!stack.isEmpty() && dp[i] < stack.peek()){
                nstop++;
                max = Math.max(nstop*stack.peek(),max);
                stack.pop();
            }


            for(int j=0;j<nstop;j++){
                stack.push(dp[i]);
            }
            stack.push(dp[i]);
        }

        for(int i=1;i<=dp.length;i++){
            max = Math.max(stack.peek()*i,max);
            stack.pop();
        }

        return max;
    }

    public static void main(String args[]){

    }
}
