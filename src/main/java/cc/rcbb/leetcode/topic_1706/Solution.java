package cc.rcbb.leetcode.topic_1706;

import cc.rcbb.leetcode.common.RcbbPrinter;

/**
 * 1706. 球会落何处
 * https://leetcode-cn.com/problems/where-will-the-ball-fall/
 */
class Solution {
    /*数据范围只有 100，直接模拟每个球从顶部的某列出发，最终到底底部哪列即可（如果可以到达的话）。

        我们使用 r 和 c 表示小球当前所处的位置，受重力影响，在不被卡住的情况下，
        r 会持续自增，直到到达底部，而 c 的变化，则是取决于当前挡板 grid[r][c] 的方向，
        若 grid[r][c] 为 11，则小球的下一个位置为 (r + 1, c + 1)(r+1,c+1)；
        若 grid[r][c] 为 -1−1，则下一位置为 (r + 1, c - 1)(r+1,c−1)，
        即可以统一表示为 (r + 1, c + grid[r][c])(r+1,c+grid[r][c])。
        当且仅当小球在本次移动过程中没被卡住，才能继续移动。
        即只有 c + grid[r][c] 没有超过矩阵的左右边界（被边界卡住），
        或者 grid[r][c] 和 grid[r][c + grid[r][c]] 同向（不形成夹角），
        小球方能继续移动。*/
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = getValue(i, grid, m, n);
        }
        return res;
    }

    private int getValue(int x, int[][] grid, int m, int n) {
        int r = 0;
        int c = x;
        while (r < m) {
            int nc = c + grid[r][c];
            if (nc < 0 || nc > n - 1) {
                return -1;
            }
            if (grid[r][c] != grid[r][nc]) {
                return -1;
            }
            r++;
            c = nc;
        }
        return c;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        RcbbPrinter.print(solution.findBall(new int[][]{{1, 1, 1, -1, -1}, {1, 1, 1, -1, -1}, {-1, -1, -1, 1, 1}, {1, 1, 1, 1, -1}, {-1, -1, -1, -1, -1}}));
        RcbbPrinter.print(solution.findBall(new int[][]{{-1}}));
        //输入：grid = [[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1],[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1]]
        //输出：[0,1,2,3,4,-1]
        RcbbPrinter.print(solution.findBall(new int[][]{{1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}, {1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}}));
    }


}