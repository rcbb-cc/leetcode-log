package cc.rcbb.leetcode.topic_10;

/**
 * 10. 正则表达式匹配
 * https://leetcode-cn.com/problems/regular-expression-matching/
 */
class Solution {
    public boolean isMatch(String s, String p) {
        return f(s, 0, p, 0);
    }

    boolean f(String s, int i, String p, int j) {
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                return f(s, i, p, j + 2) || f(s, i + 1, p, j);
            } else {
                return f(s, i + 1, p, j + 1);
            }
        } else {
            if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                return f(s, i, p, j + 2);
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //'.' 匹配任意单个字符
        //'*' 匹配零个或多个前面的那一个元素

        //输入：s = "aa" p = "a"
        //输出：false
        //解释："a" 无法匹配 "aa" 整个字符串。
        System.out.println(solution.isMatch("aa","a"));
        //输入：s = "aa" p = "a*"
        //输出：true
        //解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。

        //输入：s = "ab" p = ".*"
        //输出：true
        //解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。

        //输入：s = "aab" p = "c*a*b"
        //输出：true
        //解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。

        //输入：s = "mississippi" p = "mis*is*p*."
        //输出：false
    }


}