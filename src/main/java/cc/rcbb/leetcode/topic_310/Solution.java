package cc.rcbb.leetcode.topic_310;

import cc.rcbb.leetcode.common.RcbbPrinter;

import java.util.*;

/**
 * 310. 最小高度树
 * https://leetcode-cn.com/problems/minimum-height-trees/
 */
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        int[] parent = new int[n];
        //先找出任意一个节点的最远点
        int x = findLongestNode1(0, parent, adj);
        //再根据上面的点，找出最远点
        int y = findLongestNode1(x, parent, adj);
        //求出路径，从y->x
        List<Integer> path = new ArrayList<>();
        parent[x] = -1;
        while (y != -1) {
            path.add(y);
            y = parent[y];
        }

        int m = path.size();
        if (m % 2 == 0) {
            res.add(path.get(m / 2 - 1));
        }
        res.add(path.get(m / 2));
        return res;
    }

    /**
     * bfs求最远节点
     *
     * @param u
     * @param parent
     * @param adj
     * @return
     */
    public int findLongestNode(int u, int[] parent, List<Integer>[] adj) {
        int n = adj.length;
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visit = new boolean[n];
        q.offer(u);
        visit[u] = true;
        int node = -1;
        while (!q.isEmpty()) {
            int curr = q.poll();
            node = curr;
            for (int v : adj[curr]) {
                if (!visit[v]) {
                    visit[v] = true;
                    parent[v] = curr;
                    q.offer(v);
                }
            }
        }
        return node;
    }

    public int findLongestNode1(int u, int[] parent, List<Integer>[] adj) {
        int n = adj.length;
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[u] = 0;
        dfs(u, dist, parent, adj);
        int maxdist = 0;
        int node = -1;
        for (int i = 0; i < n; i++) {
            if (dist[i] > maxdist) {
                maxdist = dist[i];
                node = i;
            }
        }
        return node;
    }

    private void dfs(int u, int[] dist, int[] parent, List<Integer>[] adj) {
        for (int v : adj[u]) {
            if (dist[v] < 0) {
                dist[v] = dist[u] + 1;
                parent[v] = u;
                dfs(v, dist, parent, adj);
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入：n = 4, edges = [[1,0],[1,2],[1,3]]
        //输出：[1]
        RcbbPrinter.print(solution.findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}}));
        //输入：n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
        //输出：[3,4]
        RcbbPrinter.print(solution.findMinHeightTrees(6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}}));
    }
}