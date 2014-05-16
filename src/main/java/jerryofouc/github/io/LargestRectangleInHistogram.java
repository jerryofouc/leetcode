package jerryofouc.github.io;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 5/16/14
 * Time: 11:02
 * To change this template use File | Settings | File Templates.
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] dp) {

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
}
