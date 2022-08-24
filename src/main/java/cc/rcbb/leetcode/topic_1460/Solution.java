package cc.rcbb.leetcode.topic_1460;

import java.util.Arrays;

/**
 * 1460. 通过翻转子数组使两个数组相等
 * https://leetcode.cn/problems/make-two-arrays-equal-by-reversing-sub-arrays/
 */
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int m = target.length;
        int n = arr.length;
        if (m != n) {
            return false;
        }
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < m; i++) {
            if (target[i] != arr[i]) {
                return false;
            }
        }
        return true;
    }
}