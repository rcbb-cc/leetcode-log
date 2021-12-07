package cc.rcbb.leetcode.template;

/**
 * <p>
 * TwoDimensionalMatrixTemplate
 * </p>
 *
 * @author lvhao
 * @date 2021/12/7
 */
public class TwoDimensionalMatrixTemplate {
    /**
     * 二维矩阵遍历框架
     */
    void dfs(int[][] grid, int i, int j, boolean[][] visited) {
        int row = grid.length;
        int col = grid[0].length;
        if (i < 0 || j < 0 || i >= row || j >= col) {
            // 超出索引边界
            return;
        }
        if (visited[i][j]) {
            // 已经遍历过
            return;
        }
        // 进入节点(i,j)
        visited[i][j] = true;
        // 上
        dfs(grid, i - 1, j, visited);
        // 下
        dfs(grid, i + 1, j, visited);
        // 左
        dfs(grid, i, j - 1, visited);
        // 右
        dfs(grid, i, j + 1, visited);
    }

    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    void dfs1(int[][] grid, int i, int j, boolean[][] visited) {
        int row = grid.length;
        int col = grid[0].length;
        if (i < 0 || j < 0 || i >= row || j >= col) {
            // 超出索引边界
            return;
        }
        if (visited[i][j]) {
            // 已经遍历过
            return;
        }
        // 进入节点(i,j)
        visited[i][j] = true;
        // 递归遍历上下左右的节点
        for (int[] d : dirs) {
            int next_i = i + d[0];
            int next_j = j + d[1];
            dfs1(grid, next_i, next_j, visited);
        }
    }

}
