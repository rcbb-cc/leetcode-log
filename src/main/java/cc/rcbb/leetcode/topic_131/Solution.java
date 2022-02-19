package cc.rcbb.leetcode.topic_131;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 131. 分割回文串
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 */
class Solution {

    public List<List<String>> partition(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        // f[i][j]代表[i,j]这一段是否为回文串
        boolean[][] f = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            // 当[i,j]只有一个字符时，必然是回文串
            Arrays.fill(f[i], true);
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // 当[i, j]长度大于1时，满足 (cs[i] == cs[j] && f[i + 1][j - 1]) 即回文串
                f[i][j] = (cs[i] == cs[j] && f[i + 1][j - 1]);
            }
        }
        List<List<String>> res = new ArrayList<>();
        LinkedList<String> cur = new LinkedList<>();
        dfs(s, 0, res, cur, f);
        return res;
    }

    public void dfs(String s, int i, List<List<String>> res, LinkedList<String> cur, boolean[][] f) {
        int n = s.length();
        if (i == n) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int j = i; j < n; j++) {
            if (f[i][j]) {
                cur.add(s.substring(i, j + 1));
                dfs(s, j + 1, res, cur, f);
                cur.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.partition("a"));
        System.out.println(solution.partition("aab"));
        System.out.println(solution.partition("abababa"));
    }
}