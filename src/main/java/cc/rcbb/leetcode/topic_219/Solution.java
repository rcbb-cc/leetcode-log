package cc.rcbb.leetcode.topic_219;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 219. 存在重复元素 II
 * https://leetcode-cn.com/problems/contains-duplicate-ii/
 */
class Solution {
    /**
     * 滑动窗口
     * <p>
     * 固定的窗口长度 k，在 k 中是否存在相等的元素
     * 存在则直接返回：true
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * 使用哈希表，维护元素的下标
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    /**
     * 暴力
     */
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j] && j - i <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        //输入：nums = [1,2,3,1], k = 3
        //输出：true
        System.out.println(solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));

        //输入：nums = [1,0,1,1], k = 1
        //输出：true
        System.out.println(solution.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));

        //输入：nums = [1,2,3,1,2,3], k = 2
        //输出：false
        System.out.println(solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

}