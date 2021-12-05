package cc.rcbb.leetcode.topic_486;

/**
 * 486. 预测赢家
 * https://leetcode-cn.com/problems/predict-the-winner/
 */
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum == 0) {
            return true;
        }
        // 作为p1选手，能获得的最大值
        int p1 = f(nums, 0, nums.length - 1);
        return p1 >= sum - p1;
    }

    public int f(int[] nums, int l, int r) {
        if (l == r) {
            // base：仅有一个数时
            return nums[l];
        }
        // 选左边时，累计和
        int sLeft = 0;
        // 选右边时，累计和
        int sRight = 0;
        if (r - l == 1) {
            sLeft = nums[l];
            sRight = nums[r];
        }
        if (r - l >= 2) {
            // 我选左边时，我能选的就两种情况
            // 1.对手选左边，我的选择区间：[l+2,r]
            // 2.对手选右边，我的选择区间：[l+1,r-1]
            // 但对手肯定会留min值给我选，所以取两者中的min
            sLeft = nums[l] + Math.min(f(nums, l + 2, r), f(nums, l + 1, r - 1));
            // 右边同理
            sRight = nums[r] + Math.min(f(nums, l + 1, r - 1), f(nums, l, r - 2));
        }
        return Math.max(sLeft, sRight);
    }
}