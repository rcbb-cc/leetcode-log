package cc.rcbb.leetcode.topic_1781;

/**
 * 1781. 所有子字符串美丽值之和
 * https://leetcode.cn/problems/sum-of-beauty-of-all-substrings/
 * <p>
 * 模拟
 */
class Solution {
    public int beautySum(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] cnt = new int[26];
            int maxFreq = 0;
            for (int j = i; j < s.length(); j++) {
                cnt[s.charAt(j) - 'a']++;
                maxFreq = Math.max(maxFreq, cnt[s.charAt(j) - 'a']);
                int minFreq = s.length();
                for (int k = 0; k < 26; k++) {
                    if (cnt[k] > 0) {
                        minFreq = Math.min(minFreq, cnt[k]);
                    }
                }
                res += maxFreq - minFreq;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.beautySum("aabcb"));
        System.out.println(solution.beautySum("aabcbaa"));
    }
}