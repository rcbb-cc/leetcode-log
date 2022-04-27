package cc.rcbb.leetcode.topic_417;

import java.util.ArrayList;
import java.util.List;

/**
 * 417. 太平洋大西洋水流问题
 * https://leetcode-cn.com/problems/pacific-atlantic-water-flow/
 */
class Solution {

    int[][] dirs = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(i, 0, heights, pacific);
        }
        for (int i = 0; i < n; i++) {
            dfs(0, i, heights, pacific);
        }
        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, heights, atlantic);
        }
        for (int i = 0; i < n - 1; i++) {
            dfs(m - 1, i, heights, atlantic);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    result.add(cell);
                }
            }
        }
        return result;
    }

    private void dfs(int row, int col, int[][] heights, boolean[][] ocean) {
        if (ocean[row][col]) {
            return;
        }
        ocean[row][col] = true;
        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < heights.length &&
                    newCol >= 0 && newCol < heights[0].length &&
                    heights[newRow][newCol] >= heights[row][col]) {
                dfs(newRow, newCol, heights, ocean);
            }
        }
    }
}