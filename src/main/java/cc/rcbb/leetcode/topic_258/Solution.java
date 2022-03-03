package cc.rcbb.leetcode.topic_258;

/**
 * 258. 各位相加
 * https://leetcode-cn.com/problems/add-digits/
 */
class Solution {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }

    public int addDigits1(int num) {
        while (num > 9) {
            int t = num;
            int sum = 0;
            while (t != 0) {
                sum += t % 10;
                t = t / 10;
            }
            num = sum;
        }
        return num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addDigits(38));
        System.out.println(solution.addDigits(11));
        System.out.println(solution.addDigits(12));
    }
}