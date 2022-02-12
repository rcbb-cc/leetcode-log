package cc.rcbb.leetcode.topic_1020;

/**
 * 1020. 飞地的数量
 * https://leetcode-cn.com/problems/number-of-enclaves/
 */
class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 1) {
                f(grid, 0, i);
            }
            if (grid[m - 1][i] == 1) {
                f(grid, m - 1, i);
            }
        }
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                f(grid, i, 0);
            }
            if (grid[i][n - 1] == 1) {
                f(grid, i, n - 1);
            }
        }
        int count = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private void f(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || j < 0 || i > m - 1 || j > n - 1) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        f(grid, i + 1, j);
        f(grid, i - 1, j);
        f(grid, i, j + 1);
        f(grid, i, j - 1);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numEnclaves(new int[][]{{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}}));
        System.out.println(solution.numEnclaves(new int[][]{{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}}));
    }
}