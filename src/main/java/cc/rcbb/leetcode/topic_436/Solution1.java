package cc.rcbb.leetcode.topic_436;

import cc.rcbb.leetcode.common.RcbbPrinter;

import java.util.Arrays;

/**
 * 436. 寻找右区间
 * https://leetcode.cn/problems/find-right-interval/
 */
class Solution1 {
    /**
     * 双指针
     *
     * @param intervals
     * @return
     */
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] startIntervals = new int[n][2];
        int[][] endIntervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            startIntervals[i][0] = intervals[i][0];
            startIntervals[i][1] = i;
            endIntervals[i][0] = intervals[i][1];
            endIntervals[i][1] = i;
        }
        Arrays.sort(startIntervals, (o1, o2) -> o1[0] - o2[0]);
        Arrays.sort(endIntervals, (o1, o2) -> o1[0] - o2[0]);
        int[] ans = new int[n];
        for (int i = 0, j = 0; i < n; i++) {
            while (j < n && endIntervals[i][0] > startIntervals[j][0]) {
                j++;
            }
            if (j < n) {
                ans[endIntervals[i][1]] = startIntervals[j][1];
            } else {
                ans[endIntervals[i][1]] = -1;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        // 输入：intervals = [[3,4],[2,3],[1,2]]
        // 输出：[-1,0,1]
        // 解释：对于 [3,4] ，没有满足条件的“右侧”区间。
        // 对于 [2,3] ，区间[3,4]具有最小的“右”起点;
        // 对于 [1,2] ，区间[2,3]具有最小的“右”起点。
        RcbbPrinter.print(solution.findRightInterval(new int[][]{{3, 4}, {2, 3}, {1, 2}}));
    }
}