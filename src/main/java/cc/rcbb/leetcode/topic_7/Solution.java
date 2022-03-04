package cc.rcbb.leetcode.topic_7;


/**
 * 7. 整数反转
 * https://leetcode-cn.com/problems/reverse-integer/
 */
class Solution {
    /**
     * 对于本题，题目从文字上限制我们只能使用 32 位的数据结构（int）。
     * <p>
     * 忽略掉这个限制的解法
     */
    public int reverse(int x) {
        long ans = 0;
        while (x != 0) {
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        return (int) ans == ans ? (int) ans : 0;
    }


    public int reverse2(int x) {
        int res = 0;
        while (x != 0) {
            int t = x % 10;
            if (res > Integer.MAX_VALUE / 10 ||
                    (res == Integer.MAX_VALUE / 10
                            && (t > Integer.MAX_VALUE % 10))) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 ||
                    (res == Integer.MIN_VALUE / 10) &&
                            (t > -(Integer.MIN_VALUE % 10))) {
                return 0;
            }
            res = res * 10 + t;
            x = x / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(123));
        System.out.println(solution.reverse(-100));
        System.out.println(solution.reverse(120));
        System.out.println(solution.reverse(0));
        System.out.println(solution.reverse(-1247483648));
    }
}