package cc.rcbb.leetcode.topic_1703;

import java.util.ArrayList;
import java.util.List;

/**
 * 1703. 得到连续 K 个 1 的最少相邻交换次数
 * https://leetcode.cn/problems/minimum-adjacent-swaps-for-k-consecutive-ones/
 * <p>
 * 贪心、前缀和
 */
class Solution {
    public int minMoves(int[] nums, int k) {
        List<Integer> g = new ArrayList<>();
        List<Integer> preSum = new ArrayList<>();
        preSum.add(0);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                g.add(i - g.size());
                preSum.add(preSum.get(preSum.size() - 1) + g.get(g.size() - 1));
            }
        }
        int m = g.size(), res = Integer.MAX_VALUE;
        for (int i = 0; i <= m - k; i++) {
            int mid = i + k / 2;
            int r = g.get(mid);
            res = Math.min(res, (1 - k % 2) * r + (preSum.get(i + k) - preSum.get(mid + 1)) - (preSum.get(mid) - preSum.get(i)));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minMoves(new int[]{1, 0, 0, 1, 0, 1}, 2));
        System.out.println(solution.minMoves(new int[]{1, 0, 0, 0, 0, 0, 1, 1}, 3));
        System.out.println(solution.minMoves(new int[]{1, 1, 0, 1}, 2));
    }
}