package jerryofouc.github.io;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xiaojiez on 1/26/17.
 */
public class MyStack {
    /** Initialize your data structure here. */
    private Queue<Integer> queue = new LinkedList<>();
    private Queue<Integer> otherQueue = new LinkedList<>();
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(queue.isEmpty()){
            throw new IllegalArgumentException();
        }
        while (queue.size()!=1){
            otherQueue.add(queue.poll());
        }
        int ret = queue.poll();
        while (!otherQueue.isEmpty()){
            queue.add(otherQueue.poll());
        }
        return ret;
    }

    /** Get the top element. */
    public int top() {
        if(queue.isEmpty()){
            throw new IllegalArgumentException();
        }
        while (queue.size()!=1){
            otherQueue.add(queue.poll());
        }
        int ret = queue.poll();
        otherQueue.add(ret);
        while (!otherQueue.isEmpty()){
            queue.add(otherQueue.poll());
        }
        return ret;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
