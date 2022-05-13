package cc.rcbb.leetcode.topic_01_05;

/**
 * 面试题 01.05. 一次编辑
 * https://leetcode.cn/problems/one-away-lcci/
 */
class Solution {
    public boolean oneEditAway(String first, String second) {
        int m = first.length(), n = second.length();
        if (Math.abs(m - n) > 1) {
            return false;
        }
        if (m - n == 1) {
            return oneEdit(second, first);
        } else if (n - m == 1) {
            return oneEdit(first, second);
        } else if (n == m) {
            boolean flag = false;
            for (int i = 0; i < m; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    if (flag) {
                        return false;
                    }
                    flag = true;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean oneEdit(String shorter, String longer) {
        int m = shorter.length(), n = longer.length();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (shorter.charAt(i) == longer.charAt(j)) {
                i++;
            }
            j++;
            if (j - i > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.oneEditAway("pale", "ple"));
        System.out.println(solution.oneEditAway("pales", "pal"));
    }

}