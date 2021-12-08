package cc.rcbb.leetcode.topic_695;

/**
 * 695. 岛屿的最大面积
 * https://leetcode-cn.com/problems/max-area-of-island/
 */
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                max = Math.max(max, dfs(grid, i, j));
            }
        }
        return max;
    }


    public int dfs(int[][] grid, int i, int j) {
        int row = grid.length;
        int col = grid[0].length;
        if (i < 0 || j < 0 || i >= row || j >= col) {
            return 0;
        }
        if (grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        return dfs(grid, i - 1, j) +
                dfs(grid, i + 1, j) +
                dfs(grid, i, j - 1) +
                dfs(grid, i, j + 1) + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[][] grid = new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int[][] grid = new int[][]{{0,0,0,0,0,0,0,0 }};
        System.out.println(solution.maxAreaOfIsland(grid));
    }

}