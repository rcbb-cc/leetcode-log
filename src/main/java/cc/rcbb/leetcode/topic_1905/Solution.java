package cc.rcbb.leetcode.topic_1905;


/**
 * 1905. 统计子岛屿
 * https://leetcode-cn.com/problems/count-sub-islands/
 */
class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int row = grid2.length;
        int col = grid2[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 当grid1为水时，如果grid2为岛，则grid2这个肯定不是子岛，直接淹掉
                if (grid1[i][j] == 0 && grid2[i][j] == 1) {
                    dfs(grid2, i, j);
                }
            }
        }
        int count = 0;
        // 剩下的grid2中的岛就肯定都是grid1中的子岛了
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid2[i][j] == 1) {
                    dfs(grid2, i, j);
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
        if (grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid1 = new int[][]{{1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 1, 1}};
        int[][] grid2 = new int[][]{{1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}};

        System.out.println(solution.countSubIslands(grid1, grid2));

    }
}