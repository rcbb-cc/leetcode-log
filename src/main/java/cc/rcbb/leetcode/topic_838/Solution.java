package cc.rcbb.leetcode.topic_838;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 838. 推多米诺
 * https://leetcode-cn.com/problems/push-dominoes/
 */
class Solution {
    public String pushDominoes(String dominoes) {
        char[] cs = dominoes.toCharArray();
        int n = cs.length;
        int[] g = new int[n];
        // int{loc,time,dire}，位置为loc的骨牌在time时刻受到一个方向为dire的力
        Deque<int[]> d = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (cs[i] == '.') {
                continue;
            }
            int dire = cs[i] == 'L' ? -1 : 1;
            d.add(new int[]{i, 1, dire});
            g[i] = 1;
        }
        while (!d.isEmpty()) {
            int[] info = d.pollFirst();
            int loc = info[0];
            int time = info[1];
            int dire = info[2];

            int ne = loc + dire;
            if (cs[loc] == '.' ||
                    (ne < 0 || ne >= n)) {
                continue;
            }
            if (g[ne] == 0) {
                d.addLast(new int[]{ne, time + 1, dire});
                g[ne] = time + 1;
                cs[ne] = dire == -1 ? 'L' : 'R';
            } else if (g[ne] == time + 1) {
                cs[ne] = '.';
            }
        }
        return String.valueOf(cs);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pushDominoes("RR.L"));
        System.out.println(solution.pushDominoes(".L.R...LR..L.."));
    }
}