package cc.rcbb.leetcode.topic_1768;

/**
 * 1768. 交替合并字符串
 * https://leetcode.cn/problems/merge-strings-alternately/
 * <p>
 * 模拟
 */
class Solution {

    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int i = 0, j = 0;
        StringBuilder res = new StringBuilder();
        while (i < m || j < n) {
            if (i < m) {
                res.append(word1.charAt(i++));
            }
            if (j < n) {
                res.append(word2.charAt(j++));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mergeAlternately("abc", "pqr"));
        System.out.println(solution.mergeAlternately("ab", "pqrs"));
        System.out.println(solution.mergeAlternately("abcd", "pq"));
    }

}