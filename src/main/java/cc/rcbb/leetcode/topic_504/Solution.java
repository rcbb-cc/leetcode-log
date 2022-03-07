package cc.rcbb.leetcode.topic_504;

/**
 * 504. 七进制数
 * https://leetcode-cn.com/problems/base-7/
 */
class Solution {

    public String convertToBase7(int num) {
        return Integer.toString(num, 7);
    }

    public String convertToBase71(int n) {
        boolean flag = n < 0;
        if (flag) {
            n = -n;
        }
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(n % 7);
            n /= 7;
        } while (n != 0);
        sb.reverse();
        return flag ? "-" + sb.toString() : sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convertToBase7(100));
        System.out.println(solution.convertToBase7(7));
        System.out.println(solution.convertToBase7(-7));
        System.out.println(solution.convertToBase7(0));
    }
}