package cc.rcbb.leetcode.topic_198;

/**
 * 198. 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 */
class Solution {

    public int rob(int[] nums) {
        return f(nums, 0);
    }

    public int f(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        return Math.max(f(nums, index + 1),
                nums[index] + f(nums, index + 2));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入：[1,2,3,1]
        //输出：4
        //解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
        //偷窃到的最高金额 = 1 + 3 = 4 。
        System.out.println(solution.rob(new int[]{1, 2, 3, 1}));
        //输入：[2,7,9,3,1]
        //输出：12
        //解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
        //偷窃到的最高金额 = 2 + 9 + 1 = 12 。
        System.out.println(solution.rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(solution.rob(new int[]{1, 2, 3, 4, 5, 6}));
    }
}