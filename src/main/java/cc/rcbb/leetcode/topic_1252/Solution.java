package cc.rcbb.leetcode.topic_1252;

/**
 * 1252. 奇数值单元格的数目
 * https://leetcode.cn/problems/cells-with-odd-values-in-a-matrix/
 */
class Solution {
    public int oddCells1(int m, int n, int[][] indices) {
        int[][] arr = new int[m][n];
        for (int[] t : indices) {
            int rol = t[0], col = t[1];
            for (int i = 0; i < n; i++) {
                arr[rol][i]++;
            }
            for (int i = 0; i < m; i++) {
                arr[i][col]++;
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] % 2 != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public int oddCells(int m, int n, int[][] indices) {
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int[] index : indices) {
            rows[index[0]]++;
            cols[index[1]]++;
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (((rows[i] + cols[j]) & 1) != 0) {
                    res++;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.oddCells(2, 3, new int[][]{{0, 1}, {1, 1}}));
    }
}