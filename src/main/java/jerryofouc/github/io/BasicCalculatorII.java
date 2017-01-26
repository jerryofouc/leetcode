package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xiaojiez on 1/26/17.
 */
public class BasicCalculatorII {
    public static int calculate(String s) {
        char[] a = s.toCharArray();
        List<Character> characterList = new ArrayList<>();
        for(int i=0;i<a.length;i++){
            if(a[i] != ' '){
                characterList.add(a[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<characterList.size();i++){
            sb.append(characterList.get(i));
        }
        s = sb.toString();

        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) != '*' && s.charAt(i) != '/'){
                stack.push(s.charAt(i));
            }else {
                char sign = s.charAt(i);
                String left = "";
                while (!stack.isEmpty()&&stack.peek() != '-'&&stack.peek() !='+'){
                    left = stack.pop() + left;
                }
                String right = "";
                for(int j=i+1;j<s.length()&&s.charAt(j)>='0' &&s.charAt(j)<='9';j++){
                    right += s.charAt(j);
                    i++;
                }


                String w ;
                if(sign=='*'){
                    w = Integer.toString(Integer.parseInt(left) * Integer.parseInt(right));
                }else {
                    w = Integer.toString(Integer.parseInt(left) / Integer.parseInt(right));
                }
                for(int j=0;j<w.length();j++){
                    stack.push(w.charAt(j));
                }
            }
        }



        int result = 0;
        String ss = "";
        while (!stack.isEmpty()){
            char c = stack.pop();
            if(c == '-'){
                result += Integer.parseInt("-"+ss);
                ss = "";
            }else if(c == '+'){
                result += Integer.parseInt(ss);
                ss ="";
            }else {
                ss = c+ss;
            }
        }
        if(!ss.isEmpty()){
            result += Integer.parseInt(ss);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculate("1*2-3*18-69"));
    }
}
