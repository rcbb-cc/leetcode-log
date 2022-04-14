package cc.rcbb.leetcode.topic_1672;

/**
 * 1672. 最富有客户的资产总量
 * https://leetcode-cn.com/problems/richest-customer-wealth/
 */
class Solution {
    public int maximumWealth(int[][] accounts) {
        int m = accounts.length;
        int n = accounts[0].length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += accounts[i][j];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 输入：accounts = [[1,5],[7,3],[3,5]]
        // 输出：10
        System.out.println(solution.maximumWealth(new int[][]{{1, 5}, {7, 3}, {3, 5}}));
    }
}