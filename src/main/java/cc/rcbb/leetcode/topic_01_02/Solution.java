package cc.rcbb.leetcode.topic_01_02;

/**
 * 面试题 01.02. 判定是否互为字符重排
 * https://leetcode.cn/problems/check-permutation-lcci/
 */
class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        int[] arr = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            arr[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.CheckPermutation("abc","bca"));
        System.out.println(solution.CheckPermutation("abc","bad"));
    }
}