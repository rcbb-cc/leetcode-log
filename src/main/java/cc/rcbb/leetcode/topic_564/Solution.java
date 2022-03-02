package cc.rcbb.leetcode.topic_564;

import java.util.ArrayList;
import java.util.List;

/**
 * 564. 寻找最近的回文数
 * https://leetcode-cn.com/problems/find-the-closest-palindrome/
 */
class Solution {
    public String nearestPalindromic(String s) {
        long cur = Long.parseLong(s);
        long ans = -1;
        List<Long> candidates = getCandidates(s);
        for (long i : candidates) {
            if (i == cur) {
                continue;
            }
            if (ans == -1) {
                ans = i;
            } else if (Math.abs(i - cur) < Math.abs(ans - cur)) {
                ans = i;
            } else if (Math.abs(i - cur) == Math.abs(ans - cur) && i < ans) {
                ans = i;
            }
        }
        return String.valueOf(ans);
    }

    private List<Long> getCandidates(String s) {
        int n = s.length();
        List<Long> candidates = new ArrayList<Long>() {{
            add((long) Math.pow(10, n - 1) - 1);
            add((long) Math.pow(10, n) + 1);
        }};
        long selfPrefix = Long.parseLong(s.substring(0, (n + 1) / 2));
        for (long i = selfPrefix - 1; i <= selfPrefix + 1; i++) {
            StringBuilder sb = new StringBuilder();
            String prefix = String.valueOf(i);
            sb.append(prefix);
            StringBuilder suffix = new StringBuilder(prefix).reverse();
            sb.append(suffix.substring(n & 1));
            String candidate = sb.toString();
            candidates.add(Long.parseLong(candidate));
        }
        return candidates;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.nearestPalindromic("100"));
        System.out.println(solution.nearestPalindromic("99"));
        System.out.println(solution.nearestPalindromic("1"));
    }
}