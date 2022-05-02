package cc.rcbb.leetcode.topic_417;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 417. 太平洋大西洋水流问题
 * https://leetcode-cn.com/problems/pacific-atlantic-water-flow/
 */
class Solution1 {

    int[][] dirs = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            bfs(i, 0, heights, pacific);
        }
        for (int i = 0; i < n; i++) {
            bfs(0, i, heights, pacific);
        }
        for (int i = 0; i < m; i++) {
            bfs(i, n - 1, heights, atlantic);
        }
        for (int i = 0; i < n - 1; i++) {
            bfs(m - 1, i, heights, atlantic);
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

    private void bfs(int row, int col, int[][] heights, boolean[][] ocean) {
        if (ocean[row][col]) {
            return;
        }
        ocean[row][col] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{row, col});
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            for (int[] dir : dirs) {
                int newRow = cell[0] + dir[0];
                int newCol = cell[1] + dir[1];
                if (newRow >= 0 && newRow < heights.length &&
                        newCol >= 0 && newCol < heights[0].length &&
                        heights[newRow][newCol] >= heights[cell[0]][cell[1]] &&
                        !ocean[newRow][newCol]) {
                    ocean[newRow][newCol] = true;
                    q.offer(new int[]{newRow, newCol});
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        // 输入: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
        // 输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
        solution1.pacificAtlantic(new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}});
    }
}