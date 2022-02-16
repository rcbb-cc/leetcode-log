package cc.rcbb.leetcode.topic_1719;

import java.util.*;

/**
 * 1719. 重构一棵树的方案数
 * https://leetcode-cn.com/problems/number-of-ways-to-reconstruct-a-tree/
 */
class Solution {
    int N = 510;
    int[] cnts = new int[N];
    int[] fa = new int[N];
    boolean[][] g = new boolean[N][N];

    public int checkWays(int[][] pairs) {
        int m = pairs.length;
        Set<Integer> set = new HashSet<>();
        for (int[] p : pairs) {
            int a = p[0];
            int b = p[1];
            g[a][b] = g[b][a] = true;
            cnts[a]++;
            cnts[b]++;
            set.add(a);
            set.add(b);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list, (a, b) -> cnts[b] - cnts[a]);
        int n = list.size();
        int root = list.get(0);
        if (m < n - 1) {
            return 0;
        }
        fa[root] = -1;
        for (int i = 1; i < n; i++) {
            int a = list.get(i);
            boolean ok = false;
            for (int j = i - 1; j >= 0 && !ok; j--) {
                Integer b = list.get(j);
                if (g[a][b]) {
                    fa[a] = b;
                    ok = true;
                }
            }
            if (!ok) {
                return 0;
            }
        }
        int c = 0;
        int ans = 1;
        for (int i : set) {
            int j = i;
            while (fa[j] != -1) {
                if (!g[i][fa[j]]) {
                    return 0;
                }
                if (cnts[i] == cnts[fa[j]]) {
                    ans = 2;
                }
                c++;
                j = fa[j];
            }
        }
        return c < m ? 0 : ans;
    }
}