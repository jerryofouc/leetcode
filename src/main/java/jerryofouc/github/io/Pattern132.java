package jerryofouc.github.io;

import java.util.Stack;

/**
 * Created by xiaojiez on 3/16/17.
 */
public class Pattern132 {
    static class Tuple{
        public Tuple(int min, int max) {
            this.min = min;
            this.max = max;
        }

        int min;
        int max;
    }
    public static boolean find132pattern(int[] nums) {
        Stack<Tuple> stack = new Stack<>();
        for(int n : nums){
            if (stack.isEmpty() || n<stack.peek().min){
                stack.push(new Tuple(n,n));
            }else if(n>stack.peek().min){
                Tuple last = stack.pop();
                if(n<last.max){
                    return true;
                }else {
                    while (!stack.isEmpty() && n>=stack.peek().max){
                        stack.pop();
                    }
                    if(!stack.isEmpty()&&stack.peek().min<n){
                        return true;
                    }
                    last.max = n;
                    stack.push(last);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,4,2};
        System.out.println(find132pattern(nums));
    }
}
