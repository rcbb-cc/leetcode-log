package cc.rcbb.leetcode.topic_847;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 847. 访问所有节点的最短路径
 * https://leetcode.cn/problems/shortest-path-visiting-all-nodes/
 */
class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] seen = new boolean[n][1 << n];
        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{i, 1 << i, 0});
            seen[i][1 << i] = true;
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            int[] tuple = queue.poll();
            int u = tuple[0], mask = tuple[1], dist = tuple[2];
            if (mask == (1 << n) - 1) {
                ans = dist;
                break;
            }
            for (int v : graph[u]) {
                int maskV = mask | (1 << v);
                if (!seen[v][maskV]) {
                    queue.offer(new int[]{v, maskV, dist + 1});
                    seen[v][maskV] = true;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 输入：graph = [[1,2,3],[0],[0],[0]]
        // 输出：4
        System.out.println(solution.shortestPathLength(new int[][]{{1, 2, 3}, {0}, {0}, {0}}));
    }
}