package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xiaojiez on 1/26/17.
 */
public class BasicCalculator {
    public static int calculate(String s) {
        char[] a = s.toCharArray();
        List<Character> characterList = new ArrayList<>();
        for(int i=0;i<a.length;i++){
            if(a[i] != ' '){
                characterList.add(a[i]);
            }
        }
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<characterList.size();i++){
            char c = characterList.get(i);
            if(c != ')'){
                stack.push(c);
            }else {
                String t = "";
                while ((c=stack.pop()) != '('){
                    t = c+t;
                }
                if(t.length() != 0){
                    Stack<Character> minStack = new Stack<>();
                    minStack.push(t.charAt(0));
                    int result1 = 0;
                    for(int j=1;j<t.length();j++){
                        if(t.charAt(j) == '+' | t.charAt(j) == '-'){
                            if(j+1<t.length()&&t.charAt(j+1) == '-'){
                                if(t.charAt(j) == '+'){
                                    t = t.substring(0,j+1) + "-"+t.substring(j+2);
                                }else {
                                    t = t.substring(0,j+1) + "+"+t.substring(j+2);
                                }
                                j++;
                            }
                            String cur ="";
                            while (!minStack.isEmpty()){
                                cur = minStack.pop() + cur;
                            }
                            result1 += Integer.parseInt(cur);
                        }
                        minStack.push(t.charAt(j));
                    }

                    String cur ="";
                    while (!minStack.isEmpty()){
                        cur = minStack.pop() + cur;
                    }
                    result1 += Integer.parseInt(cur);
                    String aa = Integer.toString(result1);
                    for(int j=0;j<aa.length();j++){
                        stack.push(aa.charAt(j));
                    }
                }
            }
        }

        String t= "";
        while (!stack.isEmpty()){
            t = stack.pop()+t;
        }

        Stack<Character> minStack = new Stack<>();
        minStack.push(t.charAt(0));
        int result = 0;
        for(int j=1;j<t.length();j++){
            if(t.charAt(j) == '+' | t.charAt(j) == '-'){
                if(j+1<t.length()&&t.charAt(j+1) == '-'){
                    if(t.charAt(j) == '+'){
                        t = t.substring(0,j+1) + "-"+t.substring(j+2);
                    }else {
                        t = t.substring(0,j+1) + "+"+t.substring(j+2);
                    }
                    j++;
                }
                String cur ="";
                while (!minStack.isEmpty()){
                    cur = minStack.pop() + cur;
                }
                result += Integer.parseInt(cur);
            }
            minStack.push(t.charAt(j));

        }

        String cur ="";
        while (!minStack.isEmpty()){
            cur = minStack.pop() + cur;
        }

        result += Integer.parseInt(cur);
        return result;

    }

    public static void main(String[] args) {
        System.out.println(calculate(" 2-(5-6)"));

    }
}
