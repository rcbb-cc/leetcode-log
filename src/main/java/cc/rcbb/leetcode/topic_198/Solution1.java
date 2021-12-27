package cc.rcbb.leetcode.topic_198;

import java.util.Arrays;

/**
 * 198. 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 */
class Solution1 {

    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return f(memo, nums, 0);
    }

    public int f(int[] memo, int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        int res = Math.max(f(memo, nums, i + 1),
                nums[i] + f(memo, nums, i + 2));
        memo[i] = res;
        return memo[i];
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
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
        System.out.println(solution.rob(new int[]{1,2,3,4,5,6}));
    }
}