package cc.rcbb.leetcode.topic_667;

import cc.rcbb.leetcode.common.RcbbPrinter;

/**
 * 667. 优美的排列 II
 * https://leetcode.cn/problems/beautiful-arrangement-ii/
 */
class Solution {
    public int[] constructArray(int n, int k) {
        int[] answer = new int[n];
        int idx = 0;
        for (int i = 1; i < n - k; i++) {
            answer[idx] = i;
            idx++;
        }
        for (int i = n - k, j = n; i <= j; i++, j--) {
            answer[idx] = i;
            idx++;
            if (i != j) {
                answer[idx] = j;
                idx++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 输入：n = 3, k = 1
        // 输出：[1, 2, 3]
        // RcbbPrinter.print(solution.constructArray(3, 1));
        // RcbbPrinter.print(solution.constructArray(3, 2));
        RcbbPrinter.print(solution.constructArray(10, 4));
    }
}