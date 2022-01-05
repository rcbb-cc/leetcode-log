package cc.rcbb.leetcode.topic_7;


/**
 * 7. 整数反转
 * https://leetcode-cn.com/problems/reverse-integer/
 */
class Solution {
    public int reverse(int x) {
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

    /**
     * 使用StringBuilder
     */
    public int reverse1(int x) {
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        sb.reverse();
        int index = sb.indexOf("-");
        int f = 1;
        if (index != -1) {
            f = -1;
            sb.deleteCharAt(index);
        }
        Long t = Long.valueOf(sb.toString());
        if (t > Integer.MAX_VALUE || t < Integer.MIN_VALUE) {
            return 0;
        }
        return Integer.valueOf(sb.toString()) * f;
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