package cc.rcbb.leetcode.topic_693;

/**
 * 693. 交替位二进制数
 * https://leetcode-cn.com/problems/binary-number-with-alternating-bits/
 */
class Solution {
    public boolean hasAlternatingBits(int n) {
        int a = n ^ (n >> 1);
        return (a & (a + 1)) == 0;
    }

    public boolean hasAlternatingBits2(int n) {
        //记录前一位的值
        int prev = 2;
        while (n != 0) {
            //对2取模
            int cur = n % 2;
            if (cur == prev) {
                return false;
            }
            prev = cur;
            //除2
            n /= 2;
        }
        return true;
    }

    public boolean hasAlternatingBits1(int n) {
        String s = Integer.toBinaryString(n);
        boolean flag = s.charAt(0) == '1' ? true : false;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '1' && flag == true) {
                return false;
            }
            if (c == '0' && flag == false) {
                return false;
            }
            flag = !flag;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hasAlternatingBits(5));
        System.out.println(solution.hasAlternatingBits(7));
        System.out.println(solution.hasAlternatingBits(11));
    }
}