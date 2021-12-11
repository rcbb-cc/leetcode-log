package cc.rcbb.leetcode.topic_712;

import java.util.Arrays;

/**
 * 712. 两个字符串的最小ASCII删除和
 * https://leetcode-cn.com/problems/minimum-ascii-delete-sum-for-two-strings/
 */
class Solution1 {
    int memo[][];

    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(s1, 0, s2, 0);
    }

    int dp(String s1, int i, String s2, int j) {
        int res = 0;
        if (i == s1.length()) {
            for (; j < s2.length(); j++) {
                res += s2.charAt(j);
            }
            return res;
        }
        if (j == s2.length()) {
            for (; i < s1.length(); i++) {
                res += s1.charAt(i);
            }
            return res;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = dp(s1, i + 1, s2, j + 1);
        } else {
            memo[i][j] = Math.min(
                    s1.charAt(i) + dp(s1, i + 1, s2, j),
                    s2.charAt(j) + dp(s1, i, s2, j + 1)
            );
        }
        return memo[i][j];
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        //输入: s1 = "sea", s2 = "eat"
        //输出: 231
        System.out.println(solution.minimumDeleteSum("sea", "eat"));
        //"delete" "leet" 403
        System.out.println(solution.minimumDeleteSum("delete", "leet"));
    }
}