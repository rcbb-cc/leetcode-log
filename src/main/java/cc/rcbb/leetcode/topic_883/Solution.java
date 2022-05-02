package cc.rcbb.leetcode.topic_883;

/**
 * 883. 三维形体投影面积
 * https://leetcode-cn.com/problems/projection-area-of-3d-shapes/
 */
class Solution {
    public int projectionArea(int[][] grid) {
        int ans1 = 0;
        int ans2 = 0;
        int ans3 = 0;
        for (int i = 0; i < grid.length; i++) {
            int a = 0;
            int b = 0;
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] > 0) {
                    ans1++;
                }
                a = Math.max(a, grid[i][j]);
                b = Math.max(b, grid[j][i]);
            }
            ans2 += a;
            ans3 += b;
        }
        return ans1 + ans2 + ans3;
    }
}