package cc.rcbb.leetcode.topic_59;

import cc.rcbb.leetcode.common.RcbbPrinter;

/**
 * 59. 螺旋矩阵 II
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int i = 1;
        int[][] arr = new int[n][n];
        int up = 0;
        int down = n - 1;
        int left = 0;
        int right = n - 1;
        while (i <= n * n) {
            if (down >= up) {
                for (int j = left; j <= right; j++) {
                    arr[up][j] = i++;
                }
                up++;
            }
            if (right >= left) {
                for (int j = up; j <= down; j++) {
                    arr[j][right] = i++;
                }
                right--;
            }
            if (down >= up) {
                for (int j = right; j >= left; j--) {
                    arr[down][j] = i++;
                }
                down--;
            }
            if (right >= left) {
                for (int j = down; j >= up; j--) {
                    arr[j][left] = i++;
                }
                left++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        RcbbPrinter.print(solution.generateMatrix(3));
        RcbbPrinter.print(solution.generateMatrix(5));
    }
}