package cc.rcbb.leetcode.topic_1758;

/**
 * 1758. 生成交替二进制字符串的最少操作数
 * https://leetcode.cn/problems/minimum-changes-to-make-alternating-binary-string/
 * <p>
 * 模拟
 */
class Solution {
    public int minOperations1(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != (char) ('0' + i % 2)) {
                cnt++;
            }
        }
        return Math.min(cnt, s.length() - cnt);
    }

    public int minOperations(String s) {
        if (s.length() == 0) {
            return 0;
        }
        boolean flag = s.charAt(0) == '0' ? true : false;
        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            boolean b = s.charAt(i) == '0' ? true : false;
            if (flag == b) {
                count++;
            }
            flag = !flag;
        }
        return Math.min(count, s.length() - count);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minOperations("0100"));
        System.out.println(solution.minOperations("10"));
        System.out.println(solution.minOperations("1111"));
    }
}