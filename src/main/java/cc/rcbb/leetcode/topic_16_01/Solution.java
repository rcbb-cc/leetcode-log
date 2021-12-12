package cc.rcbb.leetcode.topic_16_01;

/**
 * 面试题 16.04. 井字游戏
 * https://leetcode-cn.com/problems/tic-tac-toe-lcci/
 */
class Solution {
    public String tictactoe(String[] board) {
        char[][] arr = new char[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            String str = board[i];
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        if (isWin('X', arr)) {
            return "X";
        } else if (isWin('O', arr)) {
            return "O";
        } else if (isFull(arr)) {
            return "Draw";
        } else {
            return "Pending";
        }
    }
    public boolean isFull(char[][] board) {
        int m = board.length;
        for (char[] chars : board) {
            for (int j = 0; j < m; j++) {
                if (chars[j] == ' ') return false;
            }
        }
        return true;
    }

    public boolean isWin(char c, char[][] board) {
        int m = board.length;
        // 横
        for (char[] chars : board) {
            for (int j = 0; j < m; j++) {
                if (chars[j] != c) {
                    break;
                }
                if (j == m - 1) {
                    return true;
                }
            }
        }
        //  竖
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (board[j][i] != c) {
                    break;
                }
                if (j == m - 1) {
                    return true;
                }
            }
        }
        // 右斜
        for (int i = 0; i < m; i++) {
            if (board[i][i] != c) {
                break;
            }
            if (i == m - 1) {
                return true;
            }
        }
        // 左斜
        for (int i = 0; i < m; i++) {
            if (board[i][m - 1 - i] != c) {
                break;
            }
            if (i == m - 1) {
                return true;
            }
        }
        return false;
    }
}