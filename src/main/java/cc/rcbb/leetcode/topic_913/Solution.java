package cc.rcbb.leetcode.topic_913;

import java.util.Arrays;

/**
 * 913. 猫和老鼠
 * https://leetcode-cn.com/problems/cat-and-mouse/
 */
class Solution {

    private static final int DRAW = 0;
    private static final int MOUSE_WIN = 1;
    private static final int CAT_WIN = 2;


    public int catMouseGame(int[][] graph) {
        int n = graph.length;
        int[][][] memo = new int[n][n][2 * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return f(graph, n, memo, 2, 1, 0);
    }

    private int f(int[][] graph, int n, int[][][] memo, int catPos, int mousePos, int turns) {
        if (turns >= 2 * n) {
            return DRAW;
        }
        if (memo[catPos][mousePos][turns] != -1) {
            return memo[catPos][mousePos][turns];
        }
        if (mousePos == 0) {
            memo[catPos][mousePos][turns] = MOUSE_WIN;
            return MOUSE_WIN;
        }
        if (catPos == mousePos) {
            memo[catPos][mousePos][turns] = CAT_WIN;
            return CAT_WIN;
        }
        if (turns % 2 == 0) {
            int ans = CAT_WIN;
            for (int nextPos : graph[mousePos]) {
                int nextAns = f(graph, n, memo, catPos, nextPos, turns + 1);
                if (MOUSE_WIN == nextAns) {
                    memo[catPos][mousePos][turns] = MOUSE_WIN;
                    return MOUSE_WIN;
                }
                if (DRAW == nextAns) {
                    ans = DRAW;
                }
            }
            memo[catPos][mousePos][turns] = ans;
            return ans;
        } else {
            int ans = MOUSE_WIN;
            for (int nextPos : graph[catPos]) {
                if (nextPos != 0) {
                    int nextAns = f(graph, n, memo, nextPos, mousePos, turns + 1);
                    if (CAT_WIN == nextAns) {
                        memo[catPos][mousePos][turns] = CAT_WIN;
                        return CAT_WIN;
                    }
                    if (DRAW == nextAns) {
                        ans = DRAW;
                    }
                }
            }
            memo[catPos][mousePos][turns] = ans;
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入：graph = [[2,5],[3],[0,4,5],[1,4,5],[2,3],[0,2,3]]
        //输出：0
        System.out.println(solution.catMouseGame(new int[][]{{2, 5}, {3}, {0, 4, 5}, {1, 4, 5}, {2, 3}, {0, 2, 3}}));
    }

}