package cc.rcbb.leetcode.topic_931;

/**
 * 931. 下降路径最小和
 * https://leetcode-cn.com/problems/minimum-falling-path-sum/
 */
class Solution {

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp(matrix, n - 1, i));
        }
        return res;
    }

    public int dp(int[][] matrix, int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return 99999;
        }
        if (i == 0) {
            return matrix[i][j];
        }
        return matrix[i][j] + Math.min(dp(matrix, i - 1, j), Math.min(dp(matrix, i - 1, j - 1), dp(matrix, i - 1, j + 1)));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[][] matrix = new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        //int[][] matrix = new int[][]{{-19,57},{-40,-5}};
        int[][] matrix = new int[][]{{-48}};
        System.out.println(solution.minFallingPathSum(matrix));
    }

}