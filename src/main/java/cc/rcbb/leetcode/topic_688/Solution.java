package cc.rcbb.leetcode.topic_688;

/**
 * 688. 骑士在棋盘上的概率
 * https://leetcode-cn.com/problems/knight-probability-in-chessboard/
 */
class Solution {
    int[][] dirs = new int[][]{{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};

    public double knightProbability(int n, int k, int row, int column) {
        double[][][] pre = new double[n][n][k + 1];
        return f(pre, n, k, row, column);

    }

    private double f(double[][][] pre, int n, int k, int row, int column) {
        if (row < 0 || row >= n || column < 0 || column >= n) {
            return 0;
        }
        if (k == 0) {
            return 1.0;
        }
        if (pre[row][column][k] != 0) {
            return pre[row][column][k];
        }
        for (int[] d : dirs) {
            int nrow = row + d[0];
            int ncolumn = column + d[1];
            pre[row][column][k] += f(pre, n, k - 1, nrow, ncolumn) / 8;
        }
        return pre[row][column][k];
    }

    public double knightProbability1(int n, int k, int row, int column) {
        double[][][] f = new double[n][n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j][0] = 1;
            }
        }
        for (int p = 1; p <= k; p++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] d : dirs) {
                        int nx = i + d[0];
                        int ny = j + d[1];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                            continue;
                        }
                        f[i][j][p] += f[nx][ny][p - 1] / 8;
                    }
                }
            }
        }
        return f[row][column][k];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入: n = 3, k = 2, row = 0, column = 0
        //输出: 0.0625
        //解释: 有两步(到(1,2)，(2,1))可以让骑士留在棋盘上。
        //在每一个位置上，也有两种移动可以让骑士留在棋盘上。
        //骑士留在棋盘上的总概率是0.0625。
        System.out.println(solution.knightProbability(3, 2, 0, 0));
    }
}