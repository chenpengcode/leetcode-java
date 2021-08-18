package main.java.easy.design.p155;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/15
 */
class MinStack {
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
        stack2.offerLast(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack1.offerLast(x);
        int top = stack2.peekLast();
        if (x < top) {
            stack2.offerLast(x);
        } else {
            stack2.offerLast(top);
        }

    }

    public void pop() {
        stack1.pollLast();
        stack2.pollLast();
    }

    public int top() {
        return stack1.peekLast();
    }

    public int getMin() {
        return stack2.peekLast();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
