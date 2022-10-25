package cc.rcbb.leetcode.topic_934;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 934. 最短的桥
 * https://leetcode.cn/problems/shortest-bridge/
 * <p>
 * DFS、BFS
 */
class Solution {

    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        // 第一座岛的位置集合
        List<int[]> island = new ArrayList<>();
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    grid[i][j] = -1;
                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int x = cell[0], y = cell[1];
                        island.add(cell);
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dirs[k][0];
                            int ny = y + dirs[k][1];
                            if (nx >= 0 && ny >= 0 && nx < n && ny < n
                                    && grid[nx][ny] == 1) {
                                queue.offer(new int[]{nx, ny});
                                grid[nx][ny] = -1;
                            }
                        }
                    }
                    for (int[] cell : island) {
                        // 从第一座岛去搜索
                        queue.offer(cell);
                    }
                    int step = 0;
                    while (!queue.isEmpty()) {
                        int sz = queue.size();
                        for (int k = 0; k < sz; k++) {
                            int[] cell = queue.poll();
                            int x = cell[0], y = cell[1];
                            for (int d = 0; d < 4; d++) {
                                int nx = x + dirs[d][0];
                                int ny = y + dirs[d][1];
                                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                                    if (grid[nx][ny] == 0) {
                                        queue.offer(new int[]{nx, ny});
                                        grid[nx][ny] = -1;
                                    } else if (grid[nx][ny] == 1) {
                                        // 从第一座岛搜索到第二座岛时，返回
                                        return step;
                                    }
                                }
                            }
                        }
                        step++;
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.shortestBridge(new int[][]{{0, 1}, {1, 0}}));
        System.out.println(solution.shortestBridge(new int[][]{{0, 1, 0}, {0, 0, 0}, {0, 0, 1}}));
        System.out.println(solution.shortestBridge(new int[][]{{1, 1, 1, 1, 1}, {1, 0, 0, 0, 1}, {1, 0, 1, 0, 1}, {1, 0, 0, 0, 1}}));
    }
}