package cc.rcbb.leetcode.topic_1796;

/**
 * 1796. 字符串中第二大的数字
 * https://leetcode.cn/problems/second-largest-digit-in-a-string/
 * <p>
 * 模拟
 */
class Solution {
    public int secondHighest(String s) {
        int first = -1, second = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                if (num > first) {
                    second = first;
                    first = num;
                } else if (num < first && num > second) {
                    second = num;
                }
            }
        }
        return second;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.secondHighest("dfa12321afd"));
        System.out.println(solution.secondHighest("abc1111"));
    }
}