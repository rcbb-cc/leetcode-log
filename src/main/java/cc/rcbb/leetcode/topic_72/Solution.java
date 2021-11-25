package cc.rcbb.leetcode.topic_72;

/**
 * 剑指 Offer II 072. 求平方根
 * https://leetcode-cn.com/problems/jJ0w9p/
 */
class Solution {
    /**
     * 暴力求解，小心存在数据溢出的问题
     */
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        for (int i = 1; i < x; i++) {
            if (i <= x / i) {
                if ((i + 1) > x / ((i + 1))) {
                    return i;
                } else if ((i + 1) == x / (i + 1)) {
                    return i + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.mySqrt(2));
        //System.out.println(solution.mySqrt(4));
        //System.out.println(solution.mySqrt(8));
        //System.out.println(solution.mySqrt(789789));
        //System.out.println(solution.mySqrt(123456789));
        //System.out.println(solution.mySqrt(1234567891));
        System.out.println(solution.mySqrt(2147483647));
    }
}