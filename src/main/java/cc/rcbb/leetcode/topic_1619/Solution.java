package cc.rcbb.leetcode.topic_1619;

import java.util.Arrays;

/**
 * 1619. 删除某些元素后的数组均值
 * https://leetcode.cn/problems/mean-of-array-after-removing-some-elements/
 */
class Solution {
    public double trimMean(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int sum = 0;
        for (int i = n / 20; i < 19 * n / 20; i++) {
            sum += arr[i];
        }
        return sum / (n * 0.9);
    }
}