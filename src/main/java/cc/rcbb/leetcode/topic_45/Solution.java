package cc.rcbb.leetcode.topic_45;

import java.util.Arrays;

/**
 * 45. 跳跃游戏 II
 * https://leetcode-cn.com/problems/jump-game-ii/
 */
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, n);
        return f(memo, nums, 0);
    }

    public int f(int[] memo, int[] nums, int p) {
        int n = nums.length;
        if (p >= n - 1) {
            return 0;
        }
        if (memo[p] != n) {
            return memo[p];
        }
        int steps = nums[p];
        for (int i = 1; i <= steps; i++) {
            int sub = f(memo, nums, p + i);
            memo[p] = Math.min(memo[p], sub+1);
        }
        return memo[p];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入: nums = [2,3,1,1,4]
        //输出: 2
        //解释: 跳到最后一个位置的最小跳跃数是 2。
        //从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。
        System.out.println(solution.jump(new int[]{2, 3, 1, 1, 4}));
        //输入: nums = [2,3,0,1,4]
        //输出: 2
        System.out.println(solution.jump(new int[]{2,3,0,1,4}));
    }
}