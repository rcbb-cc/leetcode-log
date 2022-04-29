package cc.rcbb.leetcode.topic_357;

/**
 * 357. 统计各位数字都不同的数字个数
 * https://leetcode-cn.com/problems/count-numbers-with-unique-digits/
 */
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        // 边界情况：n=0，只有一种选择，即0
        if (n == 0) {
            return 1;
        }
        // 边界情况：n=1，有10种选择，即0-9
        if (n == 1) {
            return 10;
        }
        int res = 10;
        int cur = 9;
        /**
         * 例：n=2时，0<=x<100
         * x可以由两部分构成，只有一位数和两位数
         * 只有一位数：0-9，10个
         * 两位数：第一位选择有9种，1-9。第二位选择则是9种，0-9中去除第一位即可。
         */
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