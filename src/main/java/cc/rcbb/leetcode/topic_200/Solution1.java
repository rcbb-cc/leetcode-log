package cc.rcbb.leetcode.topic_200;

/**
 * 200. 岛屿数量
 * https://leetcode-cn.com/problems/number-of-islands/
 */
class Solution1 {
    public int numIslands(char[][] grid) {
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    // 每发现一个岛屿，岛的数量就加一
                    count++;
                    // 使用dfs将自身这个岛给淹掉
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int i, int j) {
        int row = grid.length;
        int col = grid[0].length;
        if (i < 0 || j < 0 || i >= row || j >= col) {
            // 超出边界了，返回
            return;
        }
        if (grid[i][j] == '0') {
            // 已经是海水了，返回
            return;
        }
        // 将(i,j)变为海水
        grid[i][j] = '0';
        // 向上
        dfs(grid, i - 1, j);
        // 向下
        dfs(grid, i + 1, j);
        // 向左
        dfs(grid, i, j - 1);
        // 向右
        dfs(grid, i, j + 1);
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        //char[][] grid = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        //char[][] grid = new char[][]{{'1'}, {'1'}};
        char[][] grid = new char[][]{{'1', '0', '1', '1', '0', '1', '1'}};
        System.out.println(solution.numIslands(grid));
    }
}