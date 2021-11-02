package cc.rcbb.leetcode.topic_560;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为 K 的子数组
 */
public class Solution {

    /**
     * 暴力，双重for循环
     */
    public int subarraySum1(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum == k) {
                count++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 前缀和 + 哈希
     * 时间复杂度：O(n)
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2, 3,4,5};
        int count = solution.subarraySum(nums, 3);
        System.out.println(count);
        print(nums);
    }


    public static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}