package cc.rcbb.leetcode.topic_10;

/**
 * 10. 正则表达式匹配
 * https://leetcode-cn.com/problems/regular-expression-matching/
 */
class Solution1 {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] memo = new boolean[m + 1][n + 1];
        // [0][0]代表s和p均为空字符串
        memo[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // p的第j个字符为*
                if (p.charAt(j - 1) == '*') {
                    // 匹配s的第i个字符和p的第j-1个字符
                    if (matches(s, p, i, j - 1)) {
                        // p中*前面的字符在s中出现多次或只出现过1次
                        memo[i][j] = memo[i - 1][j] || memo[i][j - 2];
                    } else {
                        // p中*前面的字符在s中出现0次
                        memo[i][j] = memo[i][j - 2];
                    }
                } else {
                    // p中第j个字符不为*
                    // 匹配s的第i个字符和p的第j个字符
                    if (matches(s, p, i, j)) {
                        // 匹配成功，状态转移；不成功，默认为false；
                        memo[i][j] = memo[i - 1][j - 1];
                    }
                }
            }
        }
        return memo[m][n];
    }

    private boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }


    public static void main(String[] args) {
        Solution1 solution = new Solution1();
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