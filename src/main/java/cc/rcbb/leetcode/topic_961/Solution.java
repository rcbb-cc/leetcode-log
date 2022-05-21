package cc.rcbb.leetcode.topic_961;

import java.util.HashMap;
import java.util.Map;

/**
 * 961. 在长度 2N 的数组中找出重复 N 次的元素
 * https://leetcode.cn/problems/n-repeated-element-in-size-2n-array/
 */
class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
            if (count == n) {
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.repeatedNTimes(new int[]{1, 2, 3, 3}));
        System.out.println(solution.repeatedNTimes(new int[]{2, 1, 2, 5, 3, 2}));
        System.out.println(solution.repeatedNTimes(new int[]{5, 1, 5, 2, 5, 3, 5, 4}));
    }
}