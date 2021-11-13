package cc.rcbb.leetcode.template;

import java.util.*;

/**
 * <p>
 * BSFTemplate
 * </p>
 *
 * @author lvhao
 * @date 2021/11/13
 */
public class BFSTemplate {

    /**
     * 计算从起点start到终点target的最近距离
     */
    int BFS(Node start, Node target) {
        // 核心数据结构
        Queue<Node> q = new ArrayDeque<>();
        // 避免走回头路
        Set<Node> visited = new HashSet<>();

        // 将起点加入队列
        q.offer(start);
        visited.add(start);

        // 记录扩散的步数
        int step = 0;

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                Node cur = q.poll();
                // 判断是否已经到达终点
                if (cur == target) {
                    return step;
                }
                // 将cur的相邻节点加入队列
                List<Node> adj = cur.adj();
                for (int j = 0; j < adj.size(); j++) {
                    Node x = adj.get(j);
                    // 如果没有走过
                    if (!visited.contains(x)) {
                        q.offer(x);
                        visited.add(x);
                    }
                }
            }
            step++;
        }
        return 0;
    }

    class Node {

        public List<Node> adj() {
            return null;
        }
    }


}

