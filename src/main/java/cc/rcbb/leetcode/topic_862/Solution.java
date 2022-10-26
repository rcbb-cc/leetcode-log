package cc.rcbb.leetcode.topic_862;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 862. 和至少为 K 的最短子数组
 * https://leetcode.cn/problems/shortest-subarray-with-sum-at-least-k/
 * <p>
 * 前缀和、双向队列
 */
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] preSumArr = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSumArr[i + 1] = preSumArr[i] + nums[i];
        }
        int res = n + 1;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            long curSum = preSumArr[i];
            while (!queue.isEmpty() && curSum - preSumArr[queue.peekFirst()] >= k) {
                res = Math.min(res, i - queue.pollFirst());
            }
            // 上面求的是 curSum - preSumArr[queue.peekFirst()] >= k
            // 所以 preSumArr[queue.peekLast()] >= curSum 的无意义
            while (!queue.isEmpty() && preSumArr[queue.peekLast()] >= curSum) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        return res < n + 1 ? res : -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.shortestSubarray(new int[]{1}, 1));
        System.out.println(solution.shortestSubarray(new int[]{1, 2}, 4));
        System.out.println(solution.shortestSubarray(new int[]{2, -1, 2}, 3));
    }
}