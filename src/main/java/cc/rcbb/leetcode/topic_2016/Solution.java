package cc.rcbb.leetcode.topic_2016;

/**
 * 2016. 增量元素之间的最大差值
 * https://leetcode-cn.com/problems/maximum-difference-between-increasing-elements/
 */
class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int res = -1;
        int min = nums[0];
        for (int i = 0; i < n; i++) {
            if (nums[i] > min) {
                res = Math.max(res, nums[i] - min);
            }
            min = Math.min(min, nums[i]);
        }
        return res;
    }

    public int maximumDifference1(int[] nums) {
        int n = nums.length;
        int res = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    res = Math.max(res, nums[j] - nums[i]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumDifference(new int[]{7, 1, 5, 4}));
        System.out.println(solution.maximumDifference(new int[]{9, 4, 3, 2}));
        System.out.println(solution.maximumDifference(new int[]{1, 5, 2, 10}));
    }
}