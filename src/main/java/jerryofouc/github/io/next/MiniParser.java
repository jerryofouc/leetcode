package jerryofouc.github.io.next;

import java.util.Stack;

/**
 * Created by xiaojiez on 2/28/17.
 */
public class MiniParser {
    public static NestedInteger deserialize(String s) {
        NestedInteger result = new NestedInteger();
        if(s.startsWith("[")){
            if(s.length() == 2){
                return result;
            }
            s = s.substring(1,s.length()-1);
        }else {
            if(!s.contains(",")){
                result.setInteger(Integer.parseInt(s));
                return result;
            }
        }
        for(int i=0;i<s.length();){
            if(s.charAt(i) == '['){
                Stack<Character> stack = new Stack<>();
                int j=i+1;
                for(;;j++){
                    if(s.charAt(j) == '['){
                        stack.push('[');
                    }else if(s.charAt(j) == ']'){
                        if(stack.isEmpty()){
                            break;
                        }else {
                            stack.pop();
                        }
                    }
                }
                result.add(deserialize(s.substring(i,j+1)));
                i = j+2;
            }else if (s.charAt(i) >='0' && s.charAt(i)<='9' || s.charAt(i)=='-'){
                int j=i+1;
                while (j<s.length()&&(s.charAt(j) >='0' && s.charAt(j)<='9'|| s.charAt(j)=='-')){
                    j++;
                }
                NestedInteger t = new NestedInteger(Integer.parseInt(s.substring(i,j)));
                result.add(t);
                i = j+1;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(deserialize("[-1]"));
    }
}
