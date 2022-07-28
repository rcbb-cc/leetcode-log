package cc.rcbb.leetcode.topic_1331;

import cc.rcbb.leetcode.common.RcbbPrinter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1331. 数组序号转换
 * https://leetcode.cn/problems/rank-transform-of-an-array/
 */
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }
        int[] clone = arr.clone();
        Arrays.sort(clone);
        Map<Integer, Integer> map = new HashMap<>();
        int index = 1;
        int t = clone[0];
        for (int i : clone) {
            if (i > t) {
                index++;
                t = i;
            }
            map.put(i, index);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        RcbbPrinter.print(solution.arrayRankTransform(new int[]{40, 10, 20, 30}));
        RcbbPrinter.print(solution.arrayRankTransform(new int[]{100, 100, 100}));
        RcbbPrinter.print(solution.arrayRankTransform(new int[]{37, 12, 28, 9, 100, 56, 80, 5, 12}));
    }
}