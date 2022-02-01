package cc.rcbb.leetcode.topic_1763;

import java.util.HashSet;
import java.util.Set;

/**
 * 1763. 最长的美好子字符串
 * https://leetcode-cn.com/problems/longest-nice-substring/
 */
class Solution {
    public String longestNiceSubstring(String s) {
        int n = s.length();
        String res = "";
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (j - i + 1 > res.length() &&
                        check(s.substring(i, j + 1))) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    private boolean check(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        for (char c : s.toCharArray()) {
            char a = Character.toLowerCase(c);
            char b = Character.toUpperCase(c);
            if (!set.contains(a) || !set.contains(b)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestNiceSubstring("YazaAay"));
        System.out.println(solution.longestNiceSubstring("Bb"));
        System.out.println(solution.longestNiceSubstring("c"));
        System.out.println(solution.longestNiceSubstring("dDzeE"));
    }
}