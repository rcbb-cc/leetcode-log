package cc.rcbb.leetcode.topic_213;

import java.util.Arrays;

/**
 * 213. 打家劫舍 II
 * https://leetcode-cn.com/problems/house-robber-ii/
 */
class Solution1 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] memo1 = new int[nums.length];
        Arrays.fill(memo1,-1);
        int[] memo2 = new int[nums.length];
        Arrays.fill(memo2,-1);
        return Math.max(f(memo1,nums, nums.length - 2, 0), f(memo2,nums, nums.length - 1, 1));
    }

    public int f(int[] memo,int[] nums, int end, int curr) {
        if (curr > end) {
            return 0;
        }
        if (memo[curr] != -1) {
            return memo[curr];
        }
        int max = Math.max(f(memo, nums, end, curr + 1),
                nums[curr] + f(memo, nums, end, curr + 2));
        memo[curr] = max;
        return memo[curr];
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        //输入：nums = [2,3,2]
        //输出：3
        //解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
        System.out.println(solution.rob(new int[]{2, 3, 2}));
        //输入：nums = [1,2,3,1]-
        //输出：4
        //解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
        //偷窃到的最高金额 = 1 + 3 = 4 。
        System.out.println(solution.rob(new int[]{1, 2, 3, 1}));
        //输入：nums = [0]
        //输出：0
        System.out.println(solution.rob(new int[]{0}));
        System.out.println(solution.rob(new int[]{1, 2, 3}));
        System.out.println(solution.rob(new int[]{1}));
        System.out.println(solution.rob(new int[]{0, 0}));
        System.out.println(solution.rob(new int[]{1, 2, 1, 1}));
    }

}