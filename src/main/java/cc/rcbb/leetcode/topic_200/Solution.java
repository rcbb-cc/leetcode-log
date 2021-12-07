package cc.rcbb.leetcode.topic_200;

/**
 * 200. 岛屿数量
 * https://leetcode-cn.com/problems/number-of-islands/
 */
class Solution {
    public int numIslands(char[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1') {
                    change(grid, row, col);
                    grid[row][col] = '0';
                    count++;
                }
            }
        }
        return count;
    }

    int count = 0;

    public void change(char[][] grid, int row, int col) {
        // 上
        for (int i = row - 1; i >= 0; i--) {
            if (grid[i][col] == '1') {
                grid[i][col] = '0';
                change(grid, i, col);
            } else {
                break;
            }
        }

        // 下
        for (int i = row + 1; i < grid.length; i++) {
            if (grid[i][col] == '1') {
                grid[i][col] = '0';
                change(grid, i, col);
            } else {
                break;
            }
        }
        // 左
        for (int i = col - 1; i >= 0; i--) {
            if (grid[row][i] == '1') {
                grid[row][i] = '0';
                change(grid, row, i);
            } else {
                break;
            }
        }
        // 右
        for (int i = col + 1; i < grid[row].length; i++) {
            if (grid[row][i] == '1') {
                grid[row][i] = '0';
                change(grid, row, i);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //char[][] grid = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        //char[][] grid = new char[][]{{'1'}, {'1'}};
        char[][] grid = new char[][]{{'1', '0', '1', '1', '0', '1', '1'}};
        solution.numIslands(grid);
        System.out.println(solution.count);
    }
}