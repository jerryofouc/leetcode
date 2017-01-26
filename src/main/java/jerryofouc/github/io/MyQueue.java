package jerryofouc.github.io;

import java.util.Stack;

/**
 * Created by xiaojiez on 1/26/17.
 */
public class MyQueue {
    /** Initialize your data structure here. */
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> tmpStack = new Stack<>();
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack.isEmpty()){
            throw new IllegalArgumentException();
        }
        while (stack.size() != 1){
            tmpStack.push(stack.pop());
        }
        int result = stack.pop();
        while (!tmpStack.isEmpty()){
            stack.push(tmpStack.pop());
        }
        return result;
    }

    /** Get the front element. */
    public int peek() {
        if(stack.isEmpty()){
            throw new IllegalArgumentException();
        }
        while (stack.size() != 1){
            tmpStack.push(stack.pop());
        }
        int result = stack.pop();
        tmpStack.push(result);
        while (!tmpStack.isEmpty()){
            stack.push(tmpStack.pop());
        }
        return result;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}
