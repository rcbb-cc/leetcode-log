package cc.rcbb.leetcode.topic_172;

/**
 * 172. 阶乘后的零
 * https://leetcode-cn.com/problems/factorial-trailing-zeroes/
 */
class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        int t = 5;
        while (t <= n) {
            count += n / t;
            t *= 5;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trailingZeroes(3));
        System.out.println(solution.trailingZeroes(5));
        System.out.println(solution.trailingZeroes(0));
    }
}