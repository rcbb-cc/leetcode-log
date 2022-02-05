package cc.rcbb.leetcode.topic_1219;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1219. 黄金矿工
 * https://leetcode-cn.com/problems/path-with-maximum-gold/
 */
class Solution {
    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        int max = 0;
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            max = Math.max(max, f(grid, poll, 0));
        }
        return max;
    }

    private int f(int[][] grid, int[] startPoint, int sum) {
        int i = startPoint[0];
        int j = startPoint[1];
        if (i < 0 || j < 0 ||
                i > grid.length - 1 || j > grid[0].length - 1) {
            return sum;
        }
        if (grid[i][j] == 0) {
            return sum;
        }
        int temp = grid[i][j];
        grid[i][j] = 0;
        int f1 = f(grid, new int[]{i - 1, j}, sum + temp);
        int f2 = f(grid, new int[]{i, j - 1}, sum + temp);
        int f3 = f(grid, new int[]{i + 1, j}, sum + temp);
        int f4 = f(grid, new int[]{i, j + 1}, sum + temp);
        grid[i][j] = temp;
        return Math.max(Math.max(f1, f2), Math.max(f3, f4));
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        // 输入：grid = [[0,6,0],[5,8,7],[0,9,0]]
        // 输出：24
        // 解释：
        // [[0,6,0],
        //  [5,8,7],
        //  [0,9,0]]
        // 一种收集最多黄金的路线是：9 -> 8 -> 7。
        System.out.println(solution.getMaximumGold(new int[][]{{0, 6, 0}, {5, 8, 7}, {0, 9, 0}}));
        // 输入：grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
        // 输出：28
        // 解释：
        // [[1,0,7],
        //  [2,0,6],
        //  [3,4,5],
        //  [0,3,0],
        //  [9,0,20]]
        // 一种收集最多黄金的路线是：1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7。
        System.out.println(solution.getMaximumGold(new int[][]{{1, 0, 7}, {2, 0, 6}, {3, 4, 5}, {0, 3, 0}, {9, 0, 20}}));
    }
}