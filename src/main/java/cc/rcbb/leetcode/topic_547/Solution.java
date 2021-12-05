package cc.rcbb.leetcode.topic_547;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 547. 省份数量
 * https://leetcode-cn.com/problems/number-of-provinces/
 */
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int length = isConnected.length;
        boolean[] used = new boolean[length];
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (!used[i]) {
                dfs(isConnected, used, i);
                count++;
            }
        }
        return count;
    }

    public void dfs(int[][] isConnected, boolean[] used, int i) {
        for (int j = 0; j < isConnected.length; j++) {
            if (!used[j] && isConnected[i][j] == 1) {
                used[j] = true;
                dfs(isConnected, used, j);
            }
        }
    }

    public int bfs(int[][] isConnected) {
        int length = isConnected.length;
        boolean[] used = new boolean[length];
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            if (!used[i]) {
                q.offer(i);
                while (!q.isEmpty()) {
                    Integer k = q.poll();
                    used[k] = true;
                    for (int j = 0; j < length; j++) {
                        if (!used[j] && isConnected[k][j] == 1) {
                            used[j] = true;
                            q.offer(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] isConnected = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        //int[][] isConnected = new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        //int[][] isConnected = new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        int circleNum = solution.findCircleNum(isConnected);
        System.out.println(circleNum);

    }
}