package cc.rcbb.leetcode.topic_1332;

/**
 * 1332. 删除回文子序列
 * https://leetcode-cn.com/problems/remove-palindromic-subsequences/
 */
class Solution {
    public int removePalindromeSub(String s) {
        int n = s.length();
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return 2;
            }
            left++;
            right--;
        }
        return 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removePalindromeSub("ababa"));
        System.out.println(solution.removePalindromeSub("abb"));
        System.out.println(solution.removePalindromeSub("baabb"));
    }

}