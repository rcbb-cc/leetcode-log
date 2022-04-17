package cc.rcbb.leetcode.topic_479;


/**
 * 479. 最大回文数乘积
 * https://leetcode-cn.com/problems/largest-palindrome-product/
 */
class Solution {
    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        // n位数，最大值
        int max = (int) Math.pow(10, n) - 1;
        for (int i = max; i >= 0; i--) {
            long num = i;
            long t = i;
            // 构造回文数
            while (t != 0) {
                num = num * 10 + (t % 10);
                t /= 10;
            }
            for (long j = max; j * j >= num; j--) {
                // 判断回文数是否能被整除
                if (num % j == 0) {
                    return (int) (num % 1337);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //[0, 9, 987, 123, 597, 677, 1218, 877, 475
        System.out.println(solution.largestPalindrome(1));
        System.out.println(solution.largestPalindrome(2));
        System.out.println(solution.largestPalindrome(3));
        System.out.println(solution.largestPalindrome(4));
        System.out.println(solution.largestPalindrome(5));
        System.out.println(solution.largestPalindrome(6));
        System.out.println(solution.largestPalindrome(7));
        System.out.println(solution.largestPalindrome(8));
    }
}