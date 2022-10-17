package cc.rcbb.leetcode.topic_904;

import java.util.HashMap;
import java.util.Map;

/**
 * 904. 水果成篮
 * https://leetcode.cn/problems/fruit-into-baskets/
 * <p>
 * 解题思路：滑动窗口
 */
class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int left = 0, right = 0, max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < n) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.totalFruit(new int[]{1, 2, 2, 3}));
        System.out.println(solution.totalFruit(new int[]{1, 2, 1}));
        System.out.println(solution.totalFruit(new int[]{0, 1, 2, 2}));
        System.out.println(solution.totalFruit(new int[]{1, 2, 3, 2, 2}));
        System.out.println(solution.totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
    }
}