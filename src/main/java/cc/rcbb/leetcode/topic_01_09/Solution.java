package cc.rcbb.leetcode.topic_01_09;

/**
 * 面试题 01.09. 字符串轮转
 * https://leetcode.cn/problems/string-rotation-lcci/
 */
class Solution {
    public boolean isFlipedString(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 != n2) {
            return false;
        }
        return (s2+s2).contains(s1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isFlipedString("waterbottle", "erbottlewat"));
        System.out.println(solution.isFlipedString("aa", "aba"));
        System.out.println(solution.isFlipedString("aab", "aba"));
    }
}