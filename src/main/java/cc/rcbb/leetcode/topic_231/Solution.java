package cc.rcbb.leetcode.topic_231;

/**
 * 231. 2 的幂
 * https://leetcode-cn.com/problems/power-of-two/
 */
class Solution {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfTwo(1));
        System.out.println(solution.isPowerOfTwo(2));
        System.out.println(solution.isPowerOfTwo(3));
        System.out.println(solution.isPowerOfTwo(4));
        System.out.println(solution.isPowerOfTwo(5));
        System.out.println(solution.isPowerOfTwo(-2147483648));
    }

}