package cc.rcbb.leetcode.topic_172;

/**
 * 172. 阶乘后的零
 * https://leetcode-cn.com/problems/factorial-trailing-zeroes/
 */
class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n != 0) {
            n = n / 5;
            count += n;
        }
        return count;
    }

    public int trailingZeroes2(int n) {
        int count = 0;
        for (int i = 5; i <= n; i = i + 5) {
            for (int x = i; x % 5 == 0; x = x / 5) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trailingZeroes(3));
        System.out.println(solution.trailingZeroes(5));
        System.out.println(solution.trailingZeroes(0));
        System.out.println(solution.trailingZeroes(6));
    }
}