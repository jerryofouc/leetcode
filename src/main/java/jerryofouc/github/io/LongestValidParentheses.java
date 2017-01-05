package jerryofouc.github.io;

import java.util.Stack;

/**
 * Created by xiaojiezhang on 1/5/17.
 * 解题思路:
 * 1.对于括号的匹配的问题还是想到stack,通过进栈出栈可以得到括号是否匹配。
 * 2.基于以下定论,如果是一个valid的序列,这些连续的sequence必定会一块进栈出栈去掉。
 * 3.如果进栈出栈出掉就剩下一些不valid index有序的序列,只需要找出他们之间的最大间距就好了。
 */
public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        Stack<Integer> characterStack = new Stack<Integer>();
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(!characterStack.isEmpty() && isMatch(chars[characterStack.peek()],chars[i])){
                characterStack.pop();
            }else {
                characterStack.push(i);
            }
        }
        int last = -1;
        int max = 0;
        for(int i=0;i<characterStack.size();i++){
            int current = characterStack.get(i);
            if(current - last-1>max){
                max = current-last-1;
                last = current;
            }else {
                last = current;
            }
        }
        if(s.length()-last-1>max){
            max = s.length()-last-1;
        }
        return max;

    }

    private static boolean isMatch(Character peek, char aChar) {
        return peek == '(' && aChar == ')';
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")(())))(())())"));
    }
}
