package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaojiez on 2/7/17.
 */
public class RemoveInvalidParentheses {
    public static List<String> removeInvalidParentheses(String s) {
        List<String> answer = new ArrayList<>();
        char[] pars = new char[]{'(',')'};
        remove(answer,s,0,0,pars);
        return answer;
    }

    private static void remove(List<String> answer, String s, int lastI, int lastJ, char[] pars) {
        for(int stack=0, i=lastI;i<s.length();i++){
            if(s.charAt(i) == pars[0]){
                stack++;
            }
            if(s.charAt(i) == pars[1]){
                stack--;
            }
            if(stack>=0){
                continue;
            }
            for(int j=lastJ;j<=i;j++){
                if(s.charAt(j)==pars[1] &&(j==lastJ || s.charAt(j)!=s.charAt(j-1))){
                    remove(answer,s.substring(0,j)+s.substring(j+1,s.length()),i,j,pars);
                }
            }
            return;
        }
        String reverse = new StringBuilder(s).reverse().toString();
        if(pars[0] == '('){
            remove(answer,reverse,0,0,new char[]{')','('});
        }else {
            answer.add(reverse);
        }

    }

    public static void main(String[] args) {
        System.out.println(removeInvalidParentheses("()())()"));
    }
}
