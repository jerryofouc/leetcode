package jerryofouc.github.io;

import java.util.Stack;

/**
 * Created by xiaojiez on 3/3/17.
 */
public class DecodeString {
    public static String decodeString(String s) {
        String result = "";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                int p = i;
                while (s.charAt(i)>='0' && s.charAt(i)<='9'){
                    i++;
                }
                int count = Integer.parseInt(s.substring(p,i));
                Stack<Character> stack = new Stack<>();
                stack.push(s.charAt(i));
                int j=i+1;
                for(;j<s.length();j++){
                    if(s.charAt(j) == '['){
                        stack.push(s.charAt(j));
                    }else if(s.charAt(j) ==']'){
                        stack.pop();
                        if(stack.isEmpty()){
                            break;
                        }
                    }
                }
                String decodeStrint = decodeString(s.substring(i+1,j));
                for(int k=0;k<count;k++){
                    result = result + decodeStrint;
                }
                i = j;
            }else {
                result = result + s.charAt(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(decodeString("100[leetcode]"));
    }
}
