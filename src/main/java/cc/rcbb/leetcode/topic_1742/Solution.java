package cc.rcbb.leetcode.topic_1742;

import java.util.HashMap;
import java.util.Map;

/**
 * 1742. 盒子中小球的最大数量
 * https://leetcode.cn/problems/maximum-number-of-balls-in-a-box/
 * <p>
 * 模拟
 */
class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int res = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            int key = getSum(i);
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
            res = Math.max(res, countMap.get(key));
        }
        return res;
    }

    public int getSum(int x) {
        int sum = 0;
        while (x != 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countBalls(1, 10));
        System.out.println(solution.countBalls(5, 15));
        System.out.println(solution.countBalls(19, 28));
    }
}