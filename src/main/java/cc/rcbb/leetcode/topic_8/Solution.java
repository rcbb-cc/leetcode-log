package cc.rcbb.leetcode.topic_8;


/**
 * 8. 字符串转换整数 (atoi)
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 */
class Solution {
    public int myAtoi(String s) {
        int len = s.length();
        char[] sArray = s.toCharArray();

        int index = 0;
        // 1.去除字符串前的空格
        while (index < len && sArray[index] == ' ') {
            index++;
        }
        // 2.如果已经完成了遍历
        if (index == len) {
            // 极端情况：空字符
            return 0;
        }
        // 3.如果出现符号字符，仅第一个有效
        int sign = 1;
        char firstChar = sArray[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }

        // 4.将后续出现的数字字符进行转换
        int res = 0;
        while (index < len) {
            char currChar = sArray[index];
            // 4.1 先判断不合法的情况
            if (currChar > '9' || currChar < '0') {
                break;
            }
            // 4.2 判断是否会超范围
            if (res > Integer.MAX_VALUE / 10 ||
                    (res == Integer.MAX_VALUE / 10
                            && ((currChar - '0') > Integer.MAX_VALUE % 10))) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 ||
                    (res == Integer.MIN_VALUE / 10) &&
                            ((currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }
            // 4.3 转换
            res = res * 10 + sign * (currChar - '0');
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("42"));
        System.out.println(solution.myAtoi("   -42"));
        System.out.println(solution.myAtoi("4193 with words"));
        System.out.println(solution.myAtoi("words and 987"));
        System.out.println(solution.myAtoi("-91283472332"));
        System.out.println(solution.myAtoi("-11.11"));
        System.out.println(solution.myAtoi("-11a11"));
        System.out.println(solution.myAtoi(".1"));
        System.out.println(solution.myAtoi("+-12"));
        System.out.println(solution.myAtoi("-2147483647"));
    }

}