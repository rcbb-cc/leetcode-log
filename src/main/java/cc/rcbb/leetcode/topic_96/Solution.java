package cc.rcbb.leetcode.topic_96;

/**
 * 96. 不同的二叉搜索树
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 */
class Solution {
    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
                //System.out.println("i=" + i + " j=" + j + " j-1=" + (j - 1) + " i-j=" + (i - j) + " dp[i]=" + dp[i]);
            }
        }
        return dp[n];
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        int r = solution.numTrees(1);
        System.out.println(r);
        r = solution.numTrees(2);
        System.out.println(r);
        r = solution.numTrees(3);
        System.out.println(r);
        r = solution.numTrees(4);
        System.out.println(r);
    }
}