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
        if (j == p.length()) {
            // 当p匹配完了，那么应该看看s匹配到哪了
            // 如果s正好也匹配完了，那么匹配成功
            return i == s.length();
        }
        if (i == s.length()) {
            // 当s匹配完了，则p剩下的内容需要能够匹配空串
            // 如果能匹配空串，则一定是字符和*成对出现的
            if ((p.length() - j) % 2 == 1) {
                return false;
            }
            // 检查是否为 x*y*z 这种形式
            for (; j + 1 < p.length(); j += 2) {
                if (p.charAt(j + 1) != '*') {
                    return false;
                }
            }
            return true;
        }
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                // 有*的情况下，可以匹配0次或多次
                // +2 代表匹配0次，直接跳过这个*
                return f(s, i, p, j + 2) || f(s, i + 1, p, j);
            } else {
                return f(s, i + 1, p, j + 1);
            }
        } else {
            if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                // *匹配0次
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
        System.out.println(solution.isMatch("aa", "a"));
        //输入：s = "aa" p = "a*"
        //输出：true
        //解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
        System.out.println(solution.isMatch("aa", "a*"));

        //输入：s = "ab" p = ".*"
        //输出：true
        //解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
        System.out.println(solution.isMatch("aa", ".*"));

        //输入：s = "aab" p = "c*a*b"
        //输出：true
        //解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
        System.out.println(solution.isMatch("aab", "c*a*b"));

        //输入：s = "mississippi" p = "mis*is*p*."
        //输出：false
        System.out.println(solution.isMatch("mississippi", "mis*is*p*."));

    }


}