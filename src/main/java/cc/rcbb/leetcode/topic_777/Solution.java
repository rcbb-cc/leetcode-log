package cc.rcbb.leetcode.topic_777;

/**
 * 777. 在LR字符串中交换相邻字符
 * https://leetcode.cn/problems/swap-adjacent-in-lr-string/
 */
class Solution {
    public boolean canTransform(String start, String end) {
        // 1.start 和 end 字符数量相同
        // 2.每个 L 在 end 中的下标小于等于对于 L 在 start 中的下标
        // 3.每个 R 在 end 中的小标大于等于对于 R 在 start 中的下标
        // 遍历 start:i end:j 总长度:n，跳过所有的 X
        // start[i] != end[j]，return false
        // start[i] == end[j]，当前字符是 L 时，应该 i>=j，当前字符是 R 时，应该 i<=j，不符合则 return false
        // 如果 i 和 j 中有一个下标 >= n，则有一个已经遍历完，继续遍历另一个，另一个如果出现非 X 的字符，则return false
        if (start.length() != end.length()) {
            return false;
        }
        int n = start.length();
        int i = 0, j = 0;
        while (i < n && j < n) {
            while (i < n && start.charAt(i) == 'X') {
                i++;
            }
            while (j < n && end.charAt(j) == 'X') {
                j++;
            }
            if (i < n && j < n) {
                if (start.charAt(i) != end.charAt(j)) {
                    return false;
                }
                char c = start.charAt(i);
                if (c == 'L' && i < j) {
                    return false;
                }
                if (c == 'R' && i > j) {
                    return false;
                }
                i++;
                j++;
            }
        }
        while (i < n) {
            if (start.charAt(i) != 'X') {
                return false;
            }
            i++;
        }
        while (j < n) {
            if (end.charAt(j) != 'X') {
                return false;
            }
            j++;
        }
        return true;
    }
}