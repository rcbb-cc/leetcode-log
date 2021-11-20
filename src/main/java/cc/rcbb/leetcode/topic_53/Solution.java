package cc.rcbb.leetcode.topic_53;

/**
 * 53. 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        int res = -100001;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
        //输出：6
        //解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};

        //输入：nums = [1]
        //输出：1
        //int[] nums = new int[]{1};

        //输入：nums = [0]
        //输出：0
        //int[] nums = new int[]{0};

        //输入：nums = [-1]
        //输出：-1
        //int[] nums = new int[]{-1};

        //输入：nums = [-100000]
        //输出：-100000
        //int[] nums = new int[]{-100000};


        int r = solution.maxSubArray(nums);
        System.out.println(r);
    }
}