package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 2/16/14
 * Time: 16:24
 * To change this template use File | Settings | File Templates.
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<String> oprandStack = new Stack<String>();
        for (String token : tokens) {
            if(token.equals("+")){
                int p1 = Integer.parseInt(oprandStack.pop());
                int p2 = Integer.parseInt(oprandStack.pop());
                oprandStack.push(p2+p1+"");
            }else if(token.equals("-")){
                int p1 = Integer.parseInt(oprandStack.pop());
                int p2 = Integer.parseInt(oprandStack.pop());
                oprandStack.push((p2-p1)+"");
            }else if(token.equals("*")){
                int p1 = Integer.parseInt(oprandStack.pop());
                int p2 = Integer.parseInt(oprandStack.pop());
                oprandStack.push(((p2*p1)+""));
            }else if(token.equals("/")){
                int p1 = Integer.parseInt(oprandStack.pop());
                int p2 = Integer.parseInt(oprandStack.pop());
                oprandStack.push(((p2/p1)+""));
            }else{
                oprandStack.push(token);
            }
        }
        return Integer.parseInt(oprandStack.pop());
    }

}
