package cc.rcbb.leetcode.topic_443;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * 433. 最小基因变化
 * https://leetcode-cn.com/problems/minimum-genetic-mutation/
 */
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> cnt = new HashSet<>();
        Set<String> visited = new HashSet<>();
        char[] keys = {'A', 'C', 'G', 'T'};
        for (String b : bank) {
            cnt.add(b);
        }
        // 如果 tart 与 end 相等，此时直接返回 0
        if (start.equals(end)) {
            return 0;
        }
        // 最终的基因序列不在 bank 中，直接返回 -1
        if (!cnt.contains(end)) {
            return -1;
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(start);
        visited.add(start);
        int step = 1;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String curr = queue.poll();
                for (int j = 0; j < 8; j++) {
                    for (int k = 0; k < 4; k++) {
                        if (keys[k] != curr.charAt(j)) {
                            StringBuilder sb = new StringBuilder(curr);
                            sb.setCharAt(j, keys[k]);
                            String next = sb.toString();
                            // 验证合法性，必须是未重复的，必须是在结果集中存在的
                            if (!visited.contains(next) && cnt.contains(next)) {
                                // 如果与结果相同，直接返回步数
                                if (next.equals(end)) {
                                    return step;
                                }
                                queue.offer(next);
                                visited.add(next);
                            }
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));
        System.out.println(solution.minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
        System.out.println(solution.minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}));
        System.out.println(solution.minMutation("AACCTTGG", "AATTCCGG", new String[]{"AATTCCGG","AACCTGGG","AACCCCGG","AACCTACC"}));
    }

}