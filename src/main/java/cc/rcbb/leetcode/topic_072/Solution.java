package cc.rcbb.leetcode.topic_072;

/**
 * 剑指 Offer II 072. 求平方根
 * https://leetcode-cn.com/problems/jJ0w9p/
 */
class Solution {
    /**
     * 暴力求解，小心存在数据溢出的问题
     */
    public int mySqrt1(int x) {
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


    /**
     * 二分法
     */
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int result = -1;
        int left = 0;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    /**
     * 牛顿迭代
     */
    public int newton(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        return (int) sqrt(x, x);
    }

    public double sqrt(double i, int x) {
        double res = (i + x / i) / 2;
        System.out.println("i=" + i + " res=" + res);
        if (res == i) {
            return i;
        }
        return sqrt(res, x);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(2));//1
        System.out.println(solution.mySqrt(4));//2
        System.out.println(solution.newton(4));//2
        System.out.println(solution.mySqrt(8));//2
        System.out.println(solution.mySqrt(789789));//888
        System.out.println(solution.mySqrt(123456789));//11111
        System.out.println(solution.mySqrt(1234567891));//35136
        System.out.println(solution.mySqrt(2147483647));//46340
    }
}