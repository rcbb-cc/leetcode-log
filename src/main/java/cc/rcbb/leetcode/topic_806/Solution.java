package cc.rcbb.leetcode.topic_806;

import cc.rcbb.leetcode.common.RcbbPrinter;

/**
 * 806. 写字符串需要的行数
 * https://leetcode-cn.com/problems/number-of-lines-to-write-string/
 */
class Solution {

    public int[] numberOfLines(int[] widths, String s) {
        char[] chars = s.toCharArray();
        int count = 1;
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            int need = widths[chars[i] - 'a'];
            sum += need;
            if (sum > 100) {
                count++;
                sum = need;
            }
        }
        return new int[]{count, sum};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 输入:
        // widths = [10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
        // S = "abcdefghijklmnopqrstuvwxyz"
        // 输出: [3, 60]
        // 解释:
        // 所有的字符拥有相同的占用单位10。所以书写所有的26个字母，
        // 我们需要2个整行和占用60个单位的一行。
        RcbbPrinter.print(solution.numberOfLines(new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, "abcdefghijklmnopqrstuvwxyz"));
        // 输入:
        // widths = [4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
        // S = "bbbcccdddaaa"
        // 输出: [2, 4]
        // 解释:
        // 除去字母'a'所有的字符都是相同的单位10，并且字符串 "bbbcccdddaa" 将会覆盖 9 * 10 + 2 * 4 = 98 个单位.
        //         最后一个字母 'a' 将会被写到第二行，因为第一行只剩下2个单位了。
        // 所以，这个答案是2行，第二行有4个单位宽度。
        RcbbPrinter.print(solution.numberOfLines(new int[]{4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, "bbbcccdddaaa"));

        // [3,4,10,4,8,7,3,3,4,9,8,2,9,6,2,8,4,9,9,10,2,4,9,10,8,2]
        // "mqblbtpvicqhbrejb"
        RcbbPrinter.print(solution.numberOfLines(new int[]{3, 4, 10, 4, 8, 7, 3, 3, 4, 9, 8, 2, 9, 6, 2, 8, 4, 9, 9, 10, 2, 4, 9, 10, 8, 2}, "mqblbtpvicqhbrejb"));
    }
}