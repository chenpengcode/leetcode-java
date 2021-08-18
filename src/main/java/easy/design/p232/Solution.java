package main.java.easy.design.p232;

import java.util.Stack;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/7
 */
class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    int front;

    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (s1.empty()) {
            front = x;
        }
        while (!s1.empty()) {
            s2.push(s1.pop());
        }
        s2.push(x);
        while (!s2.empty()) {
            s1.push(s2.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int val = s1.pop();
        if (!s1.empty()) {
            front = s1.peek();
        }
        return val;
    }

    /** Get the front element. */
    public int peek() {
        return s1.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.empty();
    }
}

class MyQueue1 {
    Stack<Integer> s1;
    Stack<Integer> s2;
    int front;

    /** Initialize your data structure here. */
    public MyQueue1() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (s1.empty()) {
            front = x;
        }
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (s1.empty()) {
            return s2.peek();
        }
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}

