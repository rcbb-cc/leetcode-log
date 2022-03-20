package cc.rcbb.leetcode.topic_2039;

import java.util.*;

/**
 * 2039. 网络空闲的时刻
 * https://leetcode-cn.com/problems/the-time-when-the-network-becomes-idle/
 */
class Solution {
    /**
     * 核心：
     * 1.（bfs搜索）求各个节点与0号服务器的最短路径：dist
     * 2.
     * 2.1 当 2*dist <= patience[i]时，仅会发一次消息，节点变空闲的时间为：2*dist+1
     * 2.2 当 2*dist > patience[i]时，可以重发 (2*dict-1)/patience[i] 条
     * 最后一次发送消息的时间为 patience[i] * [(2*dict-1)/patience[i]]
     * 每发送一次信息就会经过2*dict收到回复
     * 则最后收到回复的时间为 patience[i] * [(2*dict-1)/patience[i]] + 2*dict
     * 因此恢复到空闲需要时间为 patience[i] * [(2*dict-1)/patience[i]] + 2*dict + 1
     * <p>
     * 当 2*dist <= patience[i]时，[(2*dict-1)/patience[i]] 一定为 0
     * 所以恢复到空闲需要时间为：patience[i] * [(2*dict-1)/patience[i]] + 2*dict + 1
     *
     * @param edges
     * @param patience
     * @return
     */
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        boolean[] visit = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visit[0] = true;
        int dist = 1;
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                for (int v : adj[curr]) {
                    if (visit[v]) {
                        continue;
                    }
                    queue.offer(v);
                    int time = patience[v] * ((2 * dist - 1) / patience[v]) + 2 * dist + 1;
                    ans = Math.max(ans, time);
                    visit[v] = true;
                }
            }
            dist++;

        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.networkBecomesIdle(new int[][]{{0, 1}, {1, 2}}, new int[]{0, 2, 1}));
        System.out.println(solution.networkBecomesIdle(new int[][]{{0, 1}, {0, 2}, {1, 2}}, new int[]{0, 10, 10}));
    }
}