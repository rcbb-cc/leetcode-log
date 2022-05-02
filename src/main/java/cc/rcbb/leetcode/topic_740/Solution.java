package cc.rcbb.leetcode.topic_740;

/**
 * 740. 删除并获得点数
 * https://leetcode-cn.com/problems/delete-and-earn/
 */
class Solution {
    public int deleteAndEarn1(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int n = max + 1;
        int[] countArray = new int[n];
        for (int num : nums) {
            countArray[num]++;
        }
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = Math.max(0, countArray[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + i * countArray[i], dp[i - 1]);
        }
        return dp[n - 1];
    }

    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int n = max + 1;
        int[] countArray = new int[n];
        for (int num : nums) {
            countArray[num]++;
        }
        // dp[i][0] 代表不选数值 i
        // dp[i][1] 代表选择数值 i
        int[][] dp = new int[n][2];
        for (int i = 1; i < n; i++) {
            dp[i][1] = dp[i - 1][0] + i * countArray[i];
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.deleteAndEarn(new int[]{3, 4, 2}));
        System.out.println(solution.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
    }
}