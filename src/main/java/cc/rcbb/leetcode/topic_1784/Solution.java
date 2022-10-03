package cc.rcbb.leetcode.topic_1784;

/**
 * 1784. 检查二进制字符串字段
 * https://leetcode.cn/problems/check-if-binary-string-has-at-most-one-segment-of-ones/
 */
class Solution {

    /**
     * 由于不可能存在前导零，所以只要存在 01，则一定有断开的 1
     *
     * @param s
     * @return
     */
    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }

    /**
     * 找最前面一个 1 和最后一个 1 ，如果中间无 0 ，则 true
     *
     * @param s
     * @return
     */
    public boolean checkOnesSegment1(String s) {
        int start = s.indexOf("1");
        int end = s.lastIndexOf("1");
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) == '0') {
                return false;
            }
        }
        return true;
    }
}