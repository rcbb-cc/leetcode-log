package cc.rcbb.leetcode.topic_1;

import cc.rcbb.leetcode.common.RcbbPrinter;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 */
public class Solution {
    /**
     * 暴力，双重for循环
     * 时间复杂度：O(n)
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    /**
     * 利用 Map 存储值和下标的对应关系，如果使用(target-当前值)在 map 中可取到结果，则说明是存在另一个值的
     * 时间复杂度：O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int c = target - nums[i];
            if (map.containsKey(c)) {
                return new int[]{map.get(c), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 输入：nums = [2,7,11,15], target = 9 //输出：[0,1]
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        //输入：nums = [3,2,4], target = 6 输出：[1,2]
        //int[] nums = new int[]{3,2,4};
        //int target = 6;

        //输入：nums = [3,3], target = 6 输出：[0,1]
        //int[] nums = new int[]{3, 3};
        //int target = 6;
        int[] r1 = solution.twoSum(nums, target);
        RcbbPrinter.print(r1);


    }
}