package cc.rcbb.leetcode.topic_796;

/**
 * 796. 旋转字符串
 * https://leetcode-cn.com/problems/rotate-string/
 */
class Solution {

    public boolean rotateString(String s, String goal) {
        int m = s.length();
        int n = goal.length();
        if (m != n) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (s.charAt((i + j) % n) != goal.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }

    public boolean rotateString1(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        return (s + s).contains(goal);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入: s = "abcde", goal = "cdeab"
        //输出: true
        System.out.println(solution.rotateString("abcde", "cdeab"));
        //输入: s = "abcde", goal = "abced"
        //输出: false
        System.out.println(solution.rotateString("abcde", "abced"));
    }
}