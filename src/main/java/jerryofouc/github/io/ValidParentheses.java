package jerryofouc.github.io;

import java.util.Stack;

/**
 * Created by xiaojiezhang on 11/6/16.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        Stack<Character> a = new Stack();
        char[] ss = s.toCharArray();
        for(int i=0;i<ss.length;i++){
            if(a.size() == 0 || !isMatched(a.peek(),ss[i])){
                a.push(ss[i]);
            }else {
                a.pop();
            }
        }

        return a.size() == 0;
    }

    boolean isMatched(char a,char b){
        if(a == '(' && b ==')' || a == '[' && b ==']' || a=='{' && b=='}'){
            return true;
        }else {
            return false;
        }
    }
}
