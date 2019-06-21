package stack;

import java.util.LinkedList;
import java.util.Queue;

//用队列实现栈
public class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;

    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
        //q2里面全部放入q1
        while (!q2.isEmpty()){
            q1.add(q2.poll());
        }
        //交换q1和q2，使得q1为空队列
        Queue temp = q1;
        q1 = q2;
        q2 = temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q2.poll();
    }

    /** Get the top element. */
    public int top() {
        return q2.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q2.isEmpty();
    }
}
