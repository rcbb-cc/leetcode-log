package cc.rcbb.leetcode.topic_2022;

import cc.rcbb.leetcode.common.RcbbPrinter;

/**
 * 2022. 将一维数组转变成二维数组
 * https://leetcode-cn.com/problems/convert-1d-array-into-2d-array/
 */
class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int o = original.length;
        // 无法放满和放不下都返回空
        if (o != m * n) {
            return new int[0][0];
        }
        int[][] res = new int[m][n];
        int col = 0;
        int row = 0;
        for (int i = 0; i < o; i++) {
            if (col == n) {
                col = 0;
                row++;
            }
            res[row][col] = original[i];
            col++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] res = null;
        res = solution.construct2DArray(new int[]{1, 2, 3, 4}, 2, 2);
        RcbbPrinter.print(res);
        res = solution.construct2DArray(new int[]{1, 2, 3}, 1, 3);
        RcbbPrinter.print(res);
        res = solution.construct2DArray(new int[]{1, 2}, 1, 1);
        RcbbPrinter.print(res);
        res = solution.construct2DArray(new int[]{1, 2, 3}, 3, 1);
        RcbbPrinter.print(res);
    }
}