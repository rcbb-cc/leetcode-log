package cc.rcbb.leetcode.topic_1751;

import java.util.Arrays;

/**
 * 1751. 最多可以参加的会议数目 II
 * https://leetcode.cn/problems/maximum-number-of-events-that-can-be-attended-ii/
 */
class Solution {
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        // 根据结束时间排序
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        /**
         * dp[i][j] 考虑前 i 个事件，选择不超过 j 的最大价值
         * 每个事件，都有选择和不选择两种情况：
         * 不选：dp[i][j]=dp[i-1][j]
         * 选择：找到第 i 个事件之前，与第 i 个事件不冲突的事件，记为 last，则有 dp[i][j]=dp[last][j-1]+value;
         *
         * 两者取max，则是 dp[i][j]的值
         */
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            int[] ev = events[i - 1];
            int s = ev[0], e = ev[1], v = ev[2];

            int last = 0;
            // 从右往左找
            for (int j = i - 1; j >= 1; j--) {
                int[] prev = events[j - 1];
                // 找出第一个满足 结束时间小于当前事件的开始时间的
                if (prev[1] < s) {
                    last = j;
                    break;
                }
            }
            for (int j = 1; j <= k; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[last][j - 1] + v);
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 输入：events = [[1,2,4],[3,4,3],[2,3,1]], k = 2
        // 输出：7
        // 解释：选择绿色的活动会议 0 和 1，得到总价值和为 4 + 3 = 7 。
        System.out.println(solution.maxValue(new int[][]{{1, 2, 4}, {3, 4, 3}, {2, 3, 1}}, 2));
        System.out.println(solution.maxValue(new int[][]{{1, 2, 4}, {3, 4, 3}, {2, 3, 10}}, 2));
        System.out.println(solution.maxValue(new int[][]{{1, 1, 1}, {2, 2, 2}, {3, 3, 3}}, 2));
    }
}