package cc.rcbb.leetcode.topic_1694;

/**
 * 1694. 重新格式化电话号码
 * https://leetcode.cn/problems/reformat-phone-number/
 */
class Solution {
    public String reformatNumber(String number) {
        // 删除 所有的空格和破折号
        // 将数组从左到右 每 3 个一组 分块，直到 剩下 4 个或更少数字。
        // 剩下的数字将按下述规定再分块：4 个数字：两个分别含 2 个数字的块。
        number = number.replaceAll(" ", "")
                .replaceAll("-", "");
        char[] numbers = number.toCharArray();
        int n = number.length();
        StringBuilder sb = new StringBuilder();
        int count = 0;

        int step = 3;
        if (n == 4) {
            step = 2;
        }
        for (int i = 0; i < n; ) {
            if (count == step) {
                if (n - i == 4) {
                    step = 2;
                } else if (n - i < 4) {
                    step = n - i;
                }
                count = 0;
                sb.append("-");
            } else {
                sb.append(numbers[i++]);
                count++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reformatNumber("1-23-45 6"));
        System.out.println(solution.reformatNumber("123 4-567"));
        System.out.println(solution.reformatNumber("123 4-5678"));
        System.out.println(solution.reformatNumber("12"));
        System.out.println(solution.reformatNumber("--17-5 229 35-39475 "));
        System.out.println(solution.reformatNumber("9964-"));
    }
}