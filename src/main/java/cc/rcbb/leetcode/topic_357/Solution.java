package cc.rcbb.leetcode.topic_357;

/**
 * 357. 统计各位数字都不同的数字个数
 * https://leetcode-cn.com/problems/count-numbers-with-unique-digits/
 */
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        int res = 10;
        int cur = 9;
        for (int i = 0; i < n - 1; i++) {
            cur *= 9 - i;
            res += cur;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countNumbersWithUniqueDigits(0));
        System.out.println(solution.countNumbersWithUniqueDigits(1));
        System.out.println(solution.countNumbersWithUniqueDigits(2));
        System.out.println(solution.countNumbersWithUniqueDigits(3));
    }
}