package cc.rcbb.leetcode.topic_592;

/**
 * 592. 分数加减运算
 * https://leetcode.cn/problems/fraction-addition-and-subtraction/
 */
class Solution {
    public String fractionAddition(String expression) {
        long denominator = 0;
        long numerator = 1;
        int index = 0;
        int n = expression.length();
        while (index < n) {
            long denominator1 = 0, sign = 1;
            if (expression.charAt(index) == '-' || expression.charAt(index) == '+') {
                sign = expression.charAt(index) == '-' ? -1 : 1;
                index++;
            }
            while (index < n && Character.isDigit(expression.charAt(index))) {
                denominator1 = denominator1 * 10 + expression.charAt(index) - '0';
                index++;
            }
            denominator1 = sign * denominator1;
            index++;

            long numerator1 = 0;
            while (index < n && Character.isDigit(expression.charAt(index))) {
                numerator1 = numerator1 * 10 + expression.charAt(index) - '0';
                index++;
            }
            denominator = denominator * numerator1 + denominator1 * numerator;
            numerator *= numerator1;
        }
        if (denominator == 0) {
            return "0/1";
        }
        long g = gcd(Math.abs(denominator), numerator);
        return Long.toString(denominator / g) + "/" + Long.toString(numerator / g);
    }

    private long gcd(long a, long b) {
        long remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fractionAddition("-1/2+1/2+1/3"));
    }
}