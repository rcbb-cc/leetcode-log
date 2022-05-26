package cc.rcbb.leetcode.topic_600;

/**
 * 600. 不含连续1的非负整数
 * https://leetcode.cn/problems/non-negative-integers-without-consecutive-ones/
 */
class Solution {
    public int findIntegers(int n) {
        // 预处理32位整数
        // dp[i] 表示长度为 i 时有多少个不包含连续 1 的数
        // dp[i]=dp[i-1]+dp[i-2]
        int[] dp = new int[32];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < 32; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        int ans = 0;
        int pre = 0;
        for (int i = 31; i >= 0; i--) {
            // 找到每一个 1，看它的下一位的方案数
            // 注意：这个的 i 是从 0 开始的，他正好等于 位数-1
            // 下一位正好对应到 i 下标
            if (((n >> i) & 1) == 1) {
                ans += dp[i];
                if (pre == 1) {
                    return ans;
                }
                pre = 1;
            } else {
                pre = 0;
            }
        }
        // 当前数也是符合条件的，如果不符合在上面的return已经返回了
        return ans + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findIntegers(5));
    }
}