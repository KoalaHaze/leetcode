package stack;

import java.util.Stack;

//用栈实现队列
public class MyQueue {

    Stack<Integer> input;
    Stack<Integer> output;

    /** Initialize your data structure here. */
    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        input.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (output.size() == 0){
            while (input.size() > 0){
                output.push(input.pop());
            }
        }
        return output.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (output.size() == 0){
            while (input.size() > 0){
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        boolean b = input.isEmpty() && output.isEmpty();
        return b;
    }
}
