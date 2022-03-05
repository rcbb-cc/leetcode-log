package cc.rcbb.leetcode.topic_521;

/**
 * 521. 最长特殊序列 Ⅰ
 * https://leetcode-cn.com/problems/longest-uncommon-subsequence-i/
 */
class Solution {
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入: a = "aba", b = "cdc"
        //输出: 3
        //解释: 最长特殊序列可为 "aba" (或 "cdc")，两者均为自身的子序列且不是对方的子序列。
        System.out.println(solution.findLUSlength("aba", "cdc"));
        //输入：a = "aaa", b = "bbb"
        //输出：3
        //解释: 最长特殊序列是 "aaa" 和 "bbb" 。
        System.out.println(solution.findLUSlength("aaa", "bbb"));
        //输入：a = "aaa", b = "aaa"
        //输出：-1
        //解释: 字符串 a 的每个子序列也是字符串 b 的每个子序列。同样，字符串 b 的每个子序列也是字符串 a 的子序列。
        System.out.println(solution.findLUSlength("aaa", "aaa"));

    }
}