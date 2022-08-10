package cc.rcbb.leetcode.topic_640;

/**
 * 640. 求解方程
 * https://leetcode.cn/problems/solve-the-equation/
 */
class Solution {
    public String solveEquation(String equation) {
        int factor = 0;
        int val = 0;
        int index = 0;
        int n = equation.length();
        int sign = 1;
        while (index < n) {
            if (equation.charAt(index) == '=') {
                // 等式右边默认系数为负
                sign = -1;
                index++;
                continue;
            }
            int sign1 = sign;
            int number = 0;
            // 记录 number 是否有效
            boolean valid = false;
            if (equation.charAt(index) == '-' || equation.charAt(index) == '+') {
                sign1 = (equation.charAt(index) == '-') ? -sign1 : sign1;
                index++;
            }
            while (index < n && Character.isDigit(equation.charAt(index))) {
                number = number * 10 + (equation.charAt(index) - '0');
                index++;
                valid = true;
            }
            if (index < n && equation.charAt(index) == 'x') {
                factor += valid ? sign1 * number : sign1;
                index++;
            } else {
                val += sign1 * number;
            }
        }
        if (factor == 0) {
            return val == 0 ? "Infinite solutions" : "No solution";
        }
        return "x=" + (-val / factor);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 输入: equation = "x+5-3+x=6+x-2"
        // 输出: "x=2"
        System.out.println(solution.solveEquation("x+5-3+x=6+x-2"));

        // 输入: equation = "x=x"
        // 输出: "Infinite solutions"
        System.out.println(solution.solveEquation("x=x"));

        // 输入: equation = "2x=x"
        // 输出: "x=0"
        System.out.println(solution.solveEquation("2x=x"));
    }

}