package cc.rcbb.leetcode.topic_268;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 268. 丢失的数字
 * https://leetcode-cn.com/problems/missing-number/
 */
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = 0;
        res = res ^ n;
        for (int i = 0; i < n; i++) {
            res ^= i ^ nums[i];
        }
        return res;
    }

    public int missingNumber2(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (Integer i : nums) {
            set.add(i);
        }
        for (int i = 0; i < n; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return n;
    }

    public int missingNumber1(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.missingNumber(new int[]{3, 0, 1}));
        // System.out.println(solution.missingNumber(new int[]{0, 1}));
        // System.out.println(solution.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
        // System.out.println(solution.missingNumber(new int[]{0}));


        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.println(i^3);
        }
    }
}