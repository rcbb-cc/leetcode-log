package cc.rcbb.leetcode.topic_51;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N 皇后
 * https://leetcode-cn.com/problems/n-queens/
 */
class Solution {
    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n > 0) {
            int[][] arr = new int[n][n];
            backtrack(arr, 0, 0);
        }
        return result;
    }

    public void backtrack(int[][] arr, int i, int j) {
        if (i == arr.length && j == arr.length) {
            return;
        }



    }

    public boolean check(int[][] arr, int x, int y) {
        int length = arr.length;
        for (int k = 0; k < length; k++) {
            if (arr[k][y] == 1) {
                return false;
            }
        }
        for (int k = 0; k < length; k++) {
            if (arr[x][k] == 1) {
                return false;
            }
        }
        return true;
    }
}