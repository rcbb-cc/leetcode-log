package cc.rcbb.leetcode.topic_809;

/**
 * 809. 情感丰富的文字
 * https://leetcode.cn/problems/expressive-words/
 * <p>
 * 双指针
 */
class Solution {
    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        for (String word : words) {
            if (expand(s, word)) {
                ans++;
            }
        }
        return ans;
    }

    private boolean expand(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) != t.charAt(j)) {
                return false;
            }
            char ch = s.charAt(i);
            int cnti = 0;
            while (i < s.length() && s.charAt(i) == ch) {
                cnti++;
                i++;
            }
            int cntj = 0;
            while (j < t.length() && t.charAt(j) == ch) {
                cntj++;
                j++;
            }
            if (cnti < cntj) {
                return false;
            }
            if (cnti != cntj && cnti < 3) {
                return false;
            }
        }
        return i == s.length() && j == t.length();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"}));
    }
}