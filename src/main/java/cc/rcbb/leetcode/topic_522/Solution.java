package cc.rcbb.leetcode.topic_522;

/**
 * 522. 最长特殊序列 II
 * https://leetcode.cn/problems/longest-uncommon-subsequence-ii/
 */
class Solution {
    public int findLUSlength(String[] strs) {
        int n = strs.length;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            boolean check = true;
            for (int j = 0; j < n; j++) {
                if (i != j && isSubseq(strs[i], strs[j])) {
                    check = false;
                    break;
                }
            }
            if (check) {
                ans = Math.max(ans, strs[i].length());
            }
        }
        return ans;
    }

    public boolean isSubseq(String s, String t) {
        int ptS = 0, ptT = 0;
        while (ptS < s.length() && ptT < t.length()) {
            if (s.charAt(ptS) == t.charAt(ptT)) {
                ptS++;
            }
            ptT++;
        }
        return ptS == s.length();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // System.out.println(solution.findLUSlength(new String[]{"aba", "cdc", "eae"}));
        System.out.println(solution.findLUSlength(new String[]{"aa", "aaa", "aaa"}));
    }
}