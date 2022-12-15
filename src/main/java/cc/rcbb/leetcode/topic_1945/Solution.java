package cc.rcbb.leetcode.topic_1945;

/**
 * 1945. 字符串转化后的各位数字之和
 * https://leetcode.cn/problems/sum-of-digits-of-string-after-convert/
 * <p>
 * 模拟
 */
class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                sb.append(c - 'a' + 1);
            }
        }
        String digits = sb.toString();
        for (int i = 1; i <= k && digits.length() > 1; i++) {
            int sum = 0;
            for (int j = 0; j < digits.length(); j++) {
                sum += digits.charAt(j) - '0';
            }
            digits = Integer.toString(sum);
        }
        return Integer.parseInt(digits);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getLucky("iiii", 1));
        System.out.println(solution.getLucky("leetcode", 2));
    }
}