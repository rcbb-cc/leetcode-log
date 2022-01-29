package cc.rcbb.leetcode.topic_1765;

import cc.rcbb.leetcode.common.RcbbPrinter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1765. 地图中的最高点
 * https://leetcode-cn.com/problems/map-of-highest-peak/
 */
class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] result = new int[m][n];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    q.offer(new int[]{i, j});
                }
                result[i][j] = isWater[i][j] == 1 ? 0 : -1;
            }
        }

        int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            for (int[] t : dir) {
                int bx = x + t[0];
                int by = y + t[1];
                if (bx < 0 || by < 0 || bx > m - 1 || by > n - 1) {
                    continue;
                }
                if (result[bx][by] != -1) {
                    continue;
                }
                result[bx][by] = result[x][y] + 1;
                q.offer(new int[]{bx, by});
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        RcbbPrinter.print(solution.highestPeak(new int[][]{{0, 1}, {0, 0}}));
        RcbbPrinter.print(solution.highestPeak(new int[][]{{0, 1}, {0, 1}}));
        RcbbPrinter.print(solution.highestPeak(new int[][]{{0, 0, 1}, {1, 0, 0}, {0, 0, 0}}));
    }
}