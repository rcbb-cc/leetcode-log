package cc.rcbb.leetcode.topic_1687;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1687. 从仓库到码头运输箱子
 * https://leetcode.cn/problems/delivering-boxes-from-storage-to-ports/
 * <p>
 * 动态规划、单调队列
 */
class Solution {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int n = boxes.length;
        int[] p = new int[n + 1];
        int[] w = new int[n + 1];
        int[] neg = new int[n + 1];
        long[] W = new long[n + 1];
        for (int i = 1; i <= n; ++i) {
            p[i] = boxes[i - 1][0];
            w[i] = boxes[i - 1][1];
            if (i > 1) {
                neg[i] = neg[i - 1] + (p[i - 1] != p[i] ? 1 : 0);
            }
            W[i] = W[i - 1] + w[i];
        }

        Deque<Integer> opt = new ArrayDeque<Integer>();
        opt.offerLast(0);
        int[] f = new int[n + 1];
        int[] g = new int[n + 1];

        for (int i = 1; i <= n; ++i) {
            while (i - opt.peekFirst() > maxBoxes || W[i] - W[opt.peekFirst()] > maxWeight) {
                opt.pollFirst();
            }

            f[i] = g[opt.peekFirst()] + neg[i] + 2;

            if (i != n) {
                g[i] = f[i] - neg[i + 1];
                while (!opt.isEmpty() && g[i] <= g[opt.peekLast()]) {
                    opt.pollLast();
                }
                opt.offerLast(i);
            }
        }

        return f[n];
    }
}