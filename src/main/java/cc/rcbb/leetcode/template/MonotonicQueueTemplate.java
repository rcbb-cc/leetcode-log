package cc.rcbb.leetcode.template;

import java.util.ArrayDeque;
import java.util.LinkedList;

/**
 * 单调队列解题模板：
 *      「单调队列」的核心思路和「单调栈」类似，push 方法依然在队尾添加元素，但是要把前面比自己小的元素都删掉
 */
public class MonotonicQueueTemplate {

    // 双链表，支持头部和尾部增删元素
    private LinkedList<Integer> q = new LinkedList<>();

    // 在队尾添加元素 n
    public void push(int n) {
        // 将前面小于自己的元素都删除
        while (!q.isEmpty() && q.getLast() < n) {
            q.pollLast();
        }
        q.addLast(n);
    }

    // 返回当前队列中的最大值
    public int max() {
        return q.getFirst();
    }

    // 队头元素如果是 n，删除它
    public void pop(int n) {
        if (n == q.getFirst()) {
            q.pollFirst();
        }
    }

}
