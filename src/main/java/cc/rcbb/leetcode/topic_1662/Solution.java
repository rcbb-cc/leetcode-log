package cc.rcbb.leetcode.topic_1662;

/**
 * 1662. 检查两个字符串数组是否相等
 * https://leetcode.cn/problems/check-if-two-string-arrays-are-equivalent/
 */
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder w1 = new StringBuilder();
        for (String s : word1) {
            w1.append(s);
        }
        StringBuilder w2 = new StringBuilder();
        for (String s : word2) {
            w2.append(s);
        }
        return w1.toString().equals(w2.toString());
    }
}