package cc.rcbb.leetcode.topic_51;

import cc.rcbb.leetcode.common.RcbbPrinter;

import java.util.ArrayList;
import java.util.LinkedList;
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
            backtrack(arr, 0);
        }
        RcbbPrinter.printList(result);
        return result;
    }

    public void backtrack(int[][] arr, int y) {
        if (y == arr.length) {
            List<String> list = new LinkedList<>();
            for (int i = 0; i < arr.length; i++) {
                String s= "";
                for (int j = 0; j < arr.length; j++) {
                    if (arr[i][j] == 0) {
                        s = s + ".";
                    } else {
                        s = s + "Q";
                    }
                }
                list.add(s);
            }
            result.add(list);
            return;
        }
        int length = arr.length;
        for (int x = 0; x < length; x++) {
            if (!check(arr, x, y)) {
                continue;
            }
            arr[x][y] = 1;
            backtrack(arr, y + 1);
            arr[x][y] = 0;
        }
    }

    public boolean check(int[][] arr, int x, int y) {
        int length = arr.length;
        // x轴
        for (int k = 0; k < length; k++) {
            if (arr[k][y] == 1) {
                return false;
            }
        }
        // y轴
        for (int k = 0; k < length; k++) {
            if (arr[x][k] == 1) {
                return false;
            }
        }
        // 左上角
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] == 1) {
                return false;
            }
        }
        // 右上角
        for (int i = x + 1, j = y - 1; i < length && j >= 0; i++, j--) {
            if (arr[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solveNQueens(4);
    }
}