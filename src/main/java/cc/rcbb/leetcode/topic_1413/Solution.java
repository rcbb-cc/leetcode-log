package cc.rcbb.leetcode.topic_1413;

/**
 * 1413. 逐步求和得到正数的最小值
 * https://leetcode.cn/problems/minimum-value-to-get-positive-step-by-step-sum/
 */
class Solution {
    public int minStartValue(int[] nums) {
        int n = nums.length;
        int startValue = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum + startValue < 1) {
                startValue = 1 - sum;
            }
        }
        return startValue;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minStartValue(new int[]{-3, 2, -3, 4, 2}));
        System.out.println(solution.minStartValue(new int[]{1, 2}));
        System.out.println(solution.minStartValue(new int[]{1, -2, -3}));
    }
}