package cc.rcbb.leetcode.topic_1405;

import java.util.PriorityQueue;

/**
 * 1405. 最长快乐字符串
 * https://leetcode-cn.com/problems/longest-happy-string/
 */
class Solution {

    class Happy {
        char c;
        int count;

        public Happy(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Happy> q = new PriorityQueue<>((p1, p2) -> p2.count - p1.count);
        if (a > 0) {
            q.offer(new Happy('a', a));
        }
        if (b > 0) {
            q.offer(new Happy('b', b));
        }
        if (c > 0) {
            q.offer(new Happy('c', c));
        }
        StringBuilder res = new StringBuilder();
        while (!q.isEmpty()) {
            int n = res.length();
            Happy h = q.poll();
            if (n >= 2 &&
                    res.charAt(n - 1) == h.c &&
                    res.charAt(n - 2) == h.c) {
                if (!q.isEmpty()) {
                    Happy t = q.poll();
                    res.append(t.c);
                    if (--t.count > 0) {
                        q.offer(t);
                    }
                    q.offer(h);
                }
            } else {
                res.append(h.c);
                if (--h.count > 0) {
                    q.offer(h);
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestDiverseString(1, 1, 7));
        System.out.println(solution.longestDiverseString(2, 2, 1));
        // ccbccbbccbbccbbccbc
        System.out.println(solution.longestDiverseString(0, 8, 11));
    }
}