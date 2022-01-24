package cc.rcbb.leetcode.topic_2045;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 2045. 到达目的地的第二短时间
 * https://leetcode-cn.com/problems/second-minimum-time-to-reach-destination/
 */
class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        // 路径
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int v = edge[0] - 1;
            int u = edge[1] - 1;
            adj[v].add(u);
            adj[u].add(v);
        }

        // 距离
        int[][] dis = new int[n][2];

        for (int i = 1; i < n; i++) {
            dis[i][0] = dis[i][1] = Integer.MAX_VALUE;
        }
        dis[0][1] = Integer.MAX_VALUE;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        // 第一次入队，一定是这个点的最短路，第二次是次短路
        // 求次短距离，即 BFS 时，维护最短路和次短路
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int head = now[0];
            int path = now[1];
            for (int u : adj[head]) {
                if (dis[u][0] > path + 1) {
                    dis[u][0] = path + 1;
                    queue.offer(new int[]{u, dis[u][0]});
                } else if ((dis[u][0] < path + 1) &&
                        (dis[u][1] > path + 1)) {
                    dis[u][1] = path + 1;
                    queue.offer(new int[]{u, dis[u][1]});
                }
            }
        }
        int path = dis[n - 1][1];
        return pathToTime(path, time, change);
    }

    private int pathToTime(int len, int time, int change) {
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += time;
            if (i == len - 1) {
                break;
            }
            int period = sum / change;
            if ((period & 1) == 1) {
                sum = (period + 1) * change;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入：n = 5, edges = [[1,2],[1,3],[1,4],[3,4],[4,5]], time = 3, change = 5
        //输出：13
        System.out.println(solution.secondMinimum(5, new int[][]{{1, 2}, {1, 3}, {1, 4}, {3, 4}, {4, 5}}, 3, 5));

    }
}