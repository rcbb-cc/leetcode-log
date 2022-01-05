package cc.rcbb.leetcode.topic_913;

import java.util.Arrays;

/**
 * 913. 猫和老鼠
 * https://leetcode-cn.com/problems/cat-and-mouse/
 */
class Solution {
    /**
     * 平局
     */
    private static final int DRAW = 0;
    /**
     * 老鼠赢
     */
    private static final int MOUSE_WIN = 1;
    /**
     * 猫赢
     */
    private static final int CAT_WIN = 2;


    public int catMouseGame(int[][] graph) {
        int n = graph.length;
        // 为什么是2*n，2n次可以确保肯定有一个节点猫和老鼠走了两次
        int[][][] memo = new int[n][n][2 * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return f(graph, n, memo, 2, 1, 0);
    }

    private int f(int[][] graph, int n, int[][][] memo, int catPos, int mousePos, int turns) {
        // 超过节点数两倍，可以确定为平局
        if (turns >= 2 * n) {
            return DRAW;
        }
        // 缓存中有直接返回
        if (memo[catPos][mousePos][turns] != -1) {
            return memo[catPos][mousePos][turns];
        }
        // 老鼠赢
        if (mousePos == 0) {
            memo[catPos][mousePos][turns] = MOUSE_WIN;
            return MOUSE_WIN;
        }
        // 猫赢
        if (catPos == mousePos) {
            memo[catPos][mousePos][turns] = CAT_WIN;
            return CAT_WIN;
        }
        // 偶数，老鼠走
        if (turns % 2 == 0) {
            // 老鼠最坏的情况是猫赢
            int ans = CAT_WIN;
            // 尝试走下一个节点
            for (int nextPos : graph[mousePos]) {
                int nextAns = f(graph, n, memo, catPos, nextPos, turns + 1);
                // 如果老鼠可以赢，直接返回
                if (MOUSE_WIN == nextAns) {
                    memo[catPos][mousePos][turns] = MOUSE_WIN;
                    return MOUSE_WIN;
                }
                // 有平局情况，先记录
                if (DRAW == nextAns) {
                    ans = DRAW;
                }
            }
            // 返回老鼠走的结果
            memo[catPos][mousePos][turns] = ans;
            return ans;
        } else {
            // 猫最坏的情况是老鼠赢
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