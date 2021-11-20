package cc.rcbb.leetcode.topic_70;

/**
 * 70. 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
class Solution {
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int r = solution.climbStairs(3);
        System.out.println(r);
    }
}