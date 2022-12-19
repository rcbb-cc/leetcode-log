package cc.rcbb.leetcode.topic_1971;

import java.util.*;

/**
 * 1971. 寻找图中是否存在路径
 * https://leetcode.cn/problems/find-if-path-exists-in-graph/
 * <p>
 * BFS
 */
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            adj[x].add(y);
            adj[y].add(x);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(source);
        visited[source] = true;
        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            if (vertex == destination) {
                break;
            }
            for (int next : adj[vertex]) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
        return visited[destination];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validPath(3, new int[][]{{0, 1}, {1, 2}, {0, 2}}, 0, 2));
        System.out.println(solution.validPath(6, new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}}, 0, 5));
    }
}