package cc.rcbb.leetcode.topic_942;

import cc.rcbb.leetcode.common.RcbbPrinter;

/**
 * 942. 增减字符串匹配
 * https://leetcode.cn/problems/di-string-match/
 */
class Solution {
    /**
     * 贪心
     * <p>
     * 取值范围为 [0,n]
     * 当遇到 I 时，取最小值，则下一个值一定比当前值大。
     * 当遇到 D 时，取最大值，则下一个值一定比当前值小。
     */
    public int[] diStringMatch(String s) {
        int length = s.length();
        int[] res = new int[length + 1];
        int min = 0, max = length;
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 'I') {
                res[index++] = min++;
            } else {
                res[index++] = max--;
            }
        }
        res[index] = max;
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        RcbbPrinter.print(solution.diStringMatch("IDID"));
        RcbbPrinter.print(solution.diStringMatch("III"));
        RcbbPrinter.print(solution.diStringMatch("DDI"));
    }
}