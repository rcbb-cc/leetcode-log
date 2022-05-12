package cc.rcbb.leetcode.topic_354;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 354. 俄罗斯套娃信封问题
 * https://leetcode.cn/problems/russian-doll-envelopes/
 */
class Solution {
    /**
     * 超时
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     */
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if (n == 0) {
            return n;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                return o2[1] - o1[1];
            }
        });
        // 考虑前 i 个物品，并以第 i 个物品为结尾的最大值
        int[] dp = new int[n];
        // 最小值为1，即本身
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    // 如果 j 满足条件，尝试使用 dp[j]+1 更新 dp[i]
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 所有的 dp[i] 中取 max
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        // 输入：envelopes = [[5, 4],[6, 4],[6, 7],[2, 3]]
        // 输出：3
        // 解释：最多信封的个数为 3, 组合为: [2, 3] => [5, 4] => [6, 7]。
        System.out.println(solution.maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
        // 输入：envelopes = [[1, 1],[1, 1],[1, 1]]
        // 输出：1
        System.out.println(solution.maxEnvelopes(new int[][]{{1, 1}, {1, 1}, {1, 1}}));

    }
}