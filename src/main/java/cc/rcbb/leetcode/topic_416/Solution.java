package cc.rcbb.leetcode.topic_416;

/**
 * 416. 分割等和子集
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 */
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        // 和为奇数是，不可能划分为两个和相等的集合
        if (sum % 2 != 0) {
            return false;
        }
        int n = nums.length;
        sum = sum / 2;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i - 1] < 0) {
                    // 容量不够，j不能装入第i个物品
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 装入或不装入背包
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        //输入：nums = [1,5,11,5]
        //输出：true
        //解释：数组可以分割成 [1, 5, 5] 和 [11] 。
        int[] nums = new int[]{1, 5, 11, 5};
        System.out.println(solution.canPartition(nums));

        //输入：nums = [1,2,3,5]
        //输出：false
        System.out.println(solution.canPartition(new int[]{1, 2, 3, 5}));

    }
}