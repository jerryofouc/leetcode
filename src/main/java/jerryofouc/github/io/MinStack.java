package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaojiez on 1/17/17.
 */
public class MinStack {
    /** initialize your data structure here. */
    private List<Integer> stack = new ArrayList<Integer>();
    private List<Integer> minStack = new ArrayList<Integer>();
    public MinStack() {
    }

    public void push(int x) {
        stack.add(x);
        if(minStack.size()==0 || minStack.get(minStack.size()-1) >x){
            minStack.add(x);
        }else {
            minStack.add(minStack.get(minStack.size()-1));
        }
    }

    public void pop() {
        if(stack.size() == 0){
            throw new IllegalArgumentException();
        }
        stack.remove(stack.size()-1);
        minStack.remove(minStack.size()-1);
    }

    public int top() {
        if(stack.size() == 0){
            throw new IllegalArgumentException();
        }
        return stack.get(stack.size()-1);
    }

    public int getMin() {
        if(stack.size() == 0){
            throw new IllegalArgumentException();
        }
        return minStack.get(minStack.size()-1);
    }
}
