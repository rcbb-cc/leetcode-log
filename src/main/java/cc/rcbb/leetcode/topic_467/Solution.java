package cc.rcbb.leetcode.topic_467;

import java.util.Arrays;

/**
 * 467. 环绕字符串中唯一的子字符串
 * https://leetcode.cn/problems/unique-substrings-in-wraparound-string/
 */
class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        int k = 0;
        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) + 26) % 26 == 1) {
                k++;
            } else {
                k = 1;
            }
            dp[p.charAt(i) - 'a'] = Math.max(dp[p.charAt(i) - 'a'], k);
        }
        return Arrays.stream(dp).sum();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // System.out.println(solution.findSubstringInWraproundString("a"));
        System.out.println(solution.findSubstringInWraproundString("ab"));
        System.out.println(solution.findSubstringInWraproundString("ac"));
        System.out.println(solution.findSubstringInWraproundString("zab"));
    }
}