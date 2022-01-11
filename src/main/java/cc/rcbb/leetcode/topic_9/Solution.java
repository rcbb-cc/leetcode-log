package cc.rcbb.leetcode.topic_9;

/**
 * 9. 回文数
 * https://leetcode-cn.com/problems/palindrome-number/
 */
class Solution {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int cur = 0;
        int t = x;
        while (t > 0) {
            cur = cur * 10 + t % 10;
            t = t / 10;
        }
        return cur == x;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) {
                return false;
            }
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }

    public boolean isPalindrome1(int x) {
        if (x < 0) {
            return false;
        }

        String reverse = new StringBuilder(x + "").reverse().toString();
        return String.valueOf(x).equals(reverse);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(10201));
        System.out.println(solution.isPalindrome(121));
        System.out.println(solution.isPalindrome(-121));
        System.out.println(solution.isPalindrome(10));
        System.out.println(solution.isPalindrome(-101));
    }
}