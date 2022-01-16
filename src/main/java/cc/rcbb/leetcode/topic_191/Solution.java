package cc.rcbb.leetcode.topic_191;

/**
 * 191. 位1的个数
 * https://leetcode-cn.com/problems/number-of-1-bits/
 */
public class Solution {

    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hammingWeight(11));
        System.out.println(solution.hammingWeight(2));
        System.out.println(solution.hammingWeight(4));
        System.out.println(solution.hammingWeight(8));
    }
}