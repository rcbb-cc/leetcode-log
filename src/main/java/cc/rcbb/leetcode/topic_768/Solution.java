package cc.rcbb.leetcode.topic_768;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 768. 最多能完成排序的块 II
 * https://leetcode.cn/problems/max-chunks-to-make-sorted-ii/
 */
class Solution {
    public int maxChunksToSorted(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num:arr) {
            if (stack.isEmpty() || num >= stack.peek()) {
                stack.push(num);
            } else {
                int mx = stack.pop();
                while (!stack.isEmpty() && stack.peek() > num) {
                    stack.pop();
                }
                stack.push(mx);
            }
        }
        return stack.size();
    }
}