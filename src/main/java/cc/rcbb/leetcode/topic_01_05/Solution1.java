package cc.rcbb.leetcode.topic_01_05;

/**
 * 面试题 01.05. 一次编辑
 * https://leetcode.cn/problems/one-away-lcci/
 */
class Solution1 {
    public boolean oneEditAway(String first, String second) {
        int m = first.length(), n = second.length();
        if (Math.abs(m - n) > 1) {
            return false;
        }
        if (n > m) {
            return oneEditAway(second, first);
        }
        int i = 0, j = 0, count = 0;
        while (i < m && j < n && count <= 1) {
            char f = first.charAt(i), s = second.charAt(j);
            if (f == s) {
                i++;
                j++;
            } else {
                if (n == m) {
                    i++;
                    j++;
                    count++;
                } else {
                    i++;
                    count++;
                }
            }
        }
        if (count > 1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.oneEditAway("pale", "ple"));
        System.out.println(solution.oneEditAway("pales", "pal"));
    }

}