package cc.rcbb.leetcode.topic_213;


/**
 * 213. 打家劫舍 II
 * https://leetcode-cn.com/problems/house-robber-ii/
 */
class Solution2 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(f(nums, 0, n - 2),
                f(nums, 1, n - 1));

    }

    private int f(int[] nums, int start, int end) {
        int dp_i_1 = 0;
        int dp_i_2 = 0;
        int dp_i = 0;
        for (int i = end; i >= start; i--) {
            dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i;
    }


    public static void main(String[] args) {
        Solution2 solution = new Solution2();
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