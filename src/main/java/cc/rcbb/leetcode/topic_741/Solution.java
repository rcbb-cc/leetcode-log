package cc.rcbb.leetcode.topic_741;

import java.util.Arrays;

/**
 * 741. 摘樱桃
 * https://leetcode.cn/problems/cherry-pickup/
 */
class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] f = new int[n * 2 - 1][n][n];
        for (int i = 0; i < 2 * n - 1; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(f[i][j], Integer.MIN_VALUE);
            }
        }
        f[0][0][0] = grid[0][0];
        for (int k = 1; k < 2 * n - 1; k++) {
            for (int x1 = Math.max(k - n + 1, 0); x1 <= Math.min(k, n - 1); x1++) {
                int y1 = k - x1;
                if (grid[x1][y1] == -1) {
                    continue;
                }
                for (int x2 = x1; x2 <= Math.min(k, n - 1); x2++) {
                    int y2 = k - x2;
                    if (grid[x2][y2] == -1) {
                        continue;
                    }
                    int res = f[k - 1][x1][x2];
                    if (x1 > 0) {
                        res = Math.max(res, f[k - 1][x1 - 1][x2]);
                    }
                    if (x2 > 0) {
                        res = Math.max(res, f[k - 1][x1][x2 - 1]);
                    }
                    if (x1 > 0 && x2 > 0) {
                        res = Math.max(res, f[k - 1][x1 - 1][x2 - 1]);
                    }
                    res += grid[x1][y1];
                    if (x2 != x1) {
                        res += grid[x2][y2];
                    }
                    f[k][x1][x2] = res;
                }
            }
        }
        return Math.max(f[n * 2 - 2][n - 1][n - 1], 0);
    }

}