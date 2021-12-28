package cc.rcbb.leetcode.topic_213;

/**
 * 213. 打家劫舍 II
 * https://leetcode-cn.com/problems/house-robber-ii/
 */
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(f(nums, nums.length - 2, 0), f(nums, nums.length - 1, 1));
    }

    public int f(int[] nums, int end, int curr) {
        if (curr > end) {
            return 0;
        }
        return Math.max(f(nums, end, curr + 1),
                nums[curr] + f(nums, end, curr + 2));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入：nums = [2,3,2]
        //输出：3
        //解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
        //System.out.println(solution.rob(new int[]{2, 3, 2}));
        //输入：nums = [1,2,3,1]
        //输出：4
        //解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
        //偷窃到的最高金额 = 1 + 3 = 4 。
        //System.out.println(solution.rob(new int[]{1, 2, 3, 1}));
        //输入：nums = [0]
        //输出：0
        //System.out.println(solution.rob(new int[]{0}));
        //System.out.println(solution.rob(new int[]{1, 2, 3}));
        System.out.println(solution.rob(new int[]{1}));

    }

}