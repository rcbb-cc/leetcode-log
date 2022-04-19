package cc.rcbb.leetcode.topic_821;

import cc.rcbb.leetcode.common.RcbbPrinter;

/**
 * 821. 字符的最短距离
 * https://leetcode-cn.com/problems/shortest-distance-to-a-character/
 */
class Solution {
    public int[] shortestToChar(String s, char c) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] result = new int[n];
        for (int i = 0, index = -n; i < n; i++) {
            if (chars[i] == c) {
                index = i;
            }
            result[i] = i - index;
        }
        for (int i = n - 1, index = 2 * n; i >= 0; i--) {
            if (chars[i] == c) {
                index = i;
            }
            result[i] = Math.min(result[i], index - i);
        }
        return result;
    }

    public int[] shortestToChar1(String s, char c) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] result = new int[n];
        int index = n;
        for (int i = 0; i < n; i++) {
            if (chars[i] == c) {
                index = i;
                for (int j = index; j >= 0; j--) {
                    result[j] = Math.min((index - j), result[j]);
                }
            } else if (index == n) {
                result[i] = index;
            } else {
                result[i] = Math.abs(index - i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 输入：s = "aaab", c = "b"
        // 输出：[3,2,1,0]
        RcbbPrinter.print(solution.shortestToChar("aaab", 'b'));
    }
}