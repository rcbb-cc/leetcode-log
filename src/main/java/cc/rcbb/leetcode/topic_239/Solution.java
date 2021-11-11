package cc.rcbb.leetcode.topic_239;

import cc.rcbb.leetcode.common.RcbbPrinter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 239. 滑动窗口最大值
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class Solution {


    /**
     * 暴力
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = nums.length;
        while (left <= right - k) {
            int max = nums[left];
            for (int i = 0; i < k; i++) {
                if (nums[left + i] > max) {
                    max = nums[left + i];
                }
            }
            res.add(max);
            left++;
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    class MonotonicQueue {

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

    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        MonotonicQueue window = new MonotonicQueue();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                window.push(nums[i]);
            } else {
                window.push(nums[i]);
                res.add(window.max());
                window.pop(nums[i - k + 1]);
            }
        }

        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    /**
     * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
     * 输出：[3,3,5,5,6,7]
     * 解释：
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     * 1 [3  -1  -3] 5  3  6  7       3
     * 1  3 [-1  -3  5] 3  6  7       5
     * 1  3  -1 [-3  5  3] 6  7       5
     * 1  3  -1  -3 [5  3  6] 7       6
     * 1  3  -1  -3  5 [3  6  7]      7
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] result = solution.maxSlidingWindow(nums, k);
        RcbbPrinter.print(result);
    }
}