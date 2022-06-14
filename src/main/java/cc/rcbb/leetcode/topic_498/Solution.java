package cc.rcbb.leetcode.topic_498;

import cc.rcbb.leetcode.common.RcbbPrinter;

/**
 * 498. 对角线遍历
 * https://leetcode.cn/problems/diagonal-traverse/
 */
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] res = new int[m * n];
        int index = 0;
        int len = m + n - 1;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                // 从下往上遍历
                if (i < m) {
                    // 起点位置为 (i,0)
                    int row = i, col = 0;
                    while (row >= 0 && col < n) {
                        res[index++] = mat[row--][col++];
                    }
                } else {
                    // 起点位置为 (m-1,i-m+1)
                    int row = m - 1, col = i - m + 1;
                    while (row >= 0 && col < n) {
                        res[index++] = mat[row--][col++];
                    }
                }
            } else {
                // 从上往下遍历
                if (i < n) {
                    // 起点位置为 (0,i)
                    int row = 0, col = i;
                    while (row < m && col >= 0) {
                        res[index++] = mat[row++][col--];
                    }
                } else {
                    // 起点位置为 (i-n+1,n-1)
                    int row = i - n + 1, col = n - 1;
                    while (row < m && col >= 0) {
                        res[index++] = mat[row++][col--];
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        RcbbPrinter.print(solution.findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}}));
    }
}