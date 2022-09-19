package cc.rcbb.leetcode.topic_1636;

import cc.rcbb.leetcode.common.RcbbPrinter;

import java.util.*;

/**
 * 1636. 按照频率将数组升序排序
 * https://leetcode.cn/problems/sort-array-by-increasing-frequency/
 */
class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            list.add(num);
        }
        Collections.sort(list, (a, b) -> {
            int c1 = map.get(a);
            int c2 = map.get(b);
            if (c1 == c2) {
                return b - a;
            }
            return c1 - c2;
        });
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        RcbbPrinter.print(solution.frequencySort(new int[]{1, 1, 2, 2, 2, 3}));
        RcbbPrinter.print(solution.frequencySort(new int[]{2, 3, 1, 3, 2}));
        RcbbPrinter.print(solution.frequencySort(new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1}));
    }
}