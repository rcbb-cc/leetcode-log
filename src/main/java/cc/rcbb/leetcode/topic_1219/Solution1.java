package cc.rcbb.leetcode.topic_1219;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1219. 黄金矿工
 * https://leetcode-cn.com/problems/path-with-maximum-gold/
 */
class Solution1 {
    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] used = new boolean[m][n];
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    used[i][j] = true;
                    res = Math.max(res, f(i, j, grid, used));
                    used[i][j] = false;
                }
            }
        }
        return res;
    }

    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int f(int i, int j, int[][] grid, boolean[][] used) {
        int res = grid[i][j];
        for (int[] d : dirs) {
            int ni = i + d[0];
            int nj = j + d[1];

            if (ni < 0 || nj < 0 ||
                    ni > grid.length - 1 || nj > grid[0].length - 1) {
                continue;
            }
            if (grid[ni][nj] == 0) {
                continue;
            }
            if (used[ni][nj]) {
                continue;
            }
            used[ni][nj] = true;
            res = Math.max(res, grid[i][j] + f(ni, nj, grid, used));
            used[ni][nj] = false;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        // 输入：grid = [[0,6,0],[5,8,7],[0,9,0]]
        // 输出：24
        // 解释：
        // [[0,6,0],
        //  [5,8,7],
        //  [0,9,0]]
        // 一种收集最多黄金的路线是：9 -> 8 -> 7。
        System.out.println(solution.getMaximumGold(new int[][]{{0, 6, 0}, {5, 8, 7}, {0, 9, 0}}));
        // 输入：grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
        // 输出：28
        // 解释：
        // [[1,0,7],
        //  [2,0,6],
        //  [3,4,5],
        //  [0,3,0],
        //  [9,0,20]]
        // 一种收集最多黄金的路线是：1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7。
        System.out.println(solution.getMaximumGold(new int[][]{{1, 0, 7}, {2, 0, 6}, {3, 4, 5}, {0, 3, 0}, {9, 0, 20}}));
    }
}