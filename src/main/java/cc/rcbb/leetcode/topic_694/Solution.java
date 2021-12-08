package cc.rcbb.leetcode.topic_694;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 694.不同岛屿的数量
 * https://leetcode-cn.com/problems/number-of-distinct-islands/
 */
class Solution {
    public int numDistinctIslands(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, 666);
                    System.out.println(sb.toString());
                    set.add(sb.toString());
                }
            }
        }
        System.out.println(Arrays.toString(set.toArray()));
        return set.size();
    }

    public void dfs(int[][] grid, int i, int j, StringBuilder sb, int dir) {
        int row = grid.length;
        int col = grid[0].length;
        if (i < 0 || j < 0 || i >= row || j >= col) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        sb.append(dir).append(",");
        dfs(grid, i - 1, j, sb, 1);
        dfs(grid, i + 1, j, sb, 2);
        dfs(grid, i, j - 1, sb, 3);
        dfs(grid, i, j + 1, sb, 4);
        sb.append(-dir).append(",");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}};
        System.out.println(solution.numDistinctIslands(grid));

    }
}