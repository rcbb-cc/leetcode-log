package cc.rcbb.leetcode.topic_232;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 */
public class MyQueue {

    Stack<Integer> one = null;
    Stack<Integer> two = null;

    public MyQueue() {
        one = new Stack<>();
        two = new Stack<>();
    }

    public void push(int x) {
        one.push(x);
    }

    public int pop() {
        peek();
        return two.pop();
    }

    public int peek() {
        while (two.empty()) {
            while (!one.isEmpty()) {
                two.push(one.pop());
            }
        }
        return two.peek();
    }

    public boolean empty() {
        return one.empty() && two.empty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.pop();
        queue.push(5);
        queue.push(6);
        queue.pop();
    }
}
