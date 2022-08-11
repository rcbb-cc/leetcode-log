package cc.rcbb.leetcode.topic_1417;

/**
 * 1417. 重新格式化字符串
 * https://leetcode.cn/problems/reformat-the-string/
 */
class Solution {
    public String reformat(String s) {
        int sumDigit = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                sumDigit++;
            }
        }
        int sumAlpha = s.length() - sumDigit;
        if (Math.abs(sumDigit - sumAlpha) > 1) {
            return "";
        }
        char[] chars = s.toCharArray();
        if (sumDigit > sumAlpha) {
            sumDigit = 0;
            sumAlpha = 1;
        } else {
            sumAlpha = 0;
            sumDigit = 1;
        }
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                chars[sumDigit] = c;
                sumDigit += 2;
            } else {
                chars[sumAlpha] = c;
                sumAlpha += 2;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Solution  solution = new Solution();
        System.out.println(solution.reformat("a0b1c2"));
        System.out.println(solution.reformat("leetcode"));
        System.out.println(solution.reformat("covid2019"));
        System.out.println(solution.reformat("ab123"));
    }
}