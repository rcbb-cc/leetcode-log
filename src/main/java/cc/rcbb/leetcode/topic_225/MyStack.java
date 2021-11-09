package cc.rcbb.leetcode.topic_225;

import java.util.ArrayDeque;

/**
 * 225. 用队列实现栈
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 */
public class MyStack {

    ArrayDeque<Integer> queue = null;

    public MyStack() {
        queue = new ArrayDeque();
    }

    public void push(int x) {
        queue.addFirst(x);
    }

    public int pop() {
        return queue.pop();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}