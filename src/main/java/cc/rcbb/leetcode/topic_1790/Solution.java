package cc.rcbb.leetcode.topic_1790;

/**
 * 1790. 仅执行一次字符串交换能否使两个字符串相等
 * https://leetcode-cn.com/problems/check-if-one-string-swap-can-make-strings-equal/
 */
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        int a = -1;
        int b = -1;
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (b == -1) {
                    b = i;
                }
                a = i;
                count++;
            }
        }
        if (count > 2) {
            return false;
        }
        if (s1.charAt(a) != s2.charAt(b) || s1.charAt(b) != s2.charAt(a)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.areAlmostEqual("caa", "aaz"));
        System.out.println(solution.areAlmostEqual("bank", "kanb"));
        System.out.println(solution.areAlmostEqual("attack", "defend"));
        System.out.println(solution.areAlmostEqual("kelb", "kelb"));
        System.out.println(solution.areAlmostEqual("abcd","dcba"));
    }
}