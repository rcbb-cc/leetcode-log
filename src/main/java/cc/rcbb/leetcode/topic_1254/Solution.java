package cc.rcbb.leetcode.topic_1254;

import java.util.Arrays;

/**
 * 1254. 统计封闭岛屿的数目
 * https://leetcode-cn.com/problems/number-of-closed-islands/
 */
class Solution {
    public int closedIsland(int[][] grid) {
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        // 先将边界上的岛屿淹掉
        for (int i = 0; i < row; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, col - 1);
        }
        // 先将边界上的岛屿淹掉
        for (int j = 0; j < col; j++) {
            dfs(grid, 0, j);
            dfs(grid, row - 1, j);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int[][] grid, int i, int j) {
        int row = grid.length;
        int col = grid[0].length;
        if (i < 0 || j < 0 || i >= row || j >= col) {
            return;
        }
        if (grid[i][j] == 1) {
            return;
        }
        grid[i][j] = 1;
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[][] grid = new int[][]{
        //        {1, 1, 1, 1, 1, 1, 1},
        //        {1, 0, 0, 0, 0, 0, 1},
        //        {1, 0, 1, 1, 1, 0, 1},
        //        {1, 0, 1, 0, 1, 0, 1},
        //        {1, 0, 1, 1, 1, 0, 1},
        //        {1, 0, 0, 0, 0, 0, 1},
        //        {1, 1, 1, 1, 1, 1, 1}};
        //int[][] grid = new int[][]{{1, 1, 1, 1, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0}};
        int[][] grid = new int[][]{
                {0, 0, 1, 1, 0, 1, 0, 0, 1, 0},
                {1, 1, 0, 1, 1, 0, 1, 1, 1, 0},
                {1, 0, 1, 1, 1, 0, 0, 1, 1, 0},
                {0, 1, 1, 0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1, 1, 0, 1, 1, 0}};
        //int[][] grid = new int[][]{
        //        {1, 1, 1, 1},
        //        {0, 0, 1, 1},
        //        {1, 1, 1, 1}};
        //int[][] grid = new int[][]{
        //        {1, 1, 1, 1},
        //        {0, 0, 1, 1},
        //        {1, 1, 0, 1},
        //        {1, 1, 1, 1}};
        System.out.println(solution.closedIsland(grid));
        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
    }
}