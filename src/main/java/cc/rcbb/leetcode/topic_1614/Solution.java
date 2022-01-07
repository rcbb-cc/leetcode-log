package cc.rcbb.leetcode.topic_1614;


/**
 * 1614. 括号的最大嵌套深度
 * https://leetcode-cn.com/problems/maximum-nesting-depth-of-the-parentheses/
 */
class Solution {

    public int maxDepth(String s) {
        int res = 0;
        char[] array = s.toCharArray();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '(') {
                count++;
            } else if (array[i] == ')') {
                count--;
            }
            res = Math.max(res, count);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        //输入：s = "(1+(2*3)+((8)/4))+1"
        //输出：3
        //解释：数字 8 在嵌套的 3 层括号中。
        System.out.println(solution.maxDepth("(1+(2*3)+((8)/4))+1"));
        //输入：s = "(1)+((2))+(((3)))"
        //输出：3
        System.out.println(solution.maxDepth("(1)+((2))+(((3)))"));

        //输入：s = "1+(2*3)/(2-1)"
        //输出：1
        System.out.println(solution.maxDepth("1+(2*3)/(2-1)"));

        //输入：s = "1"
        //输出：0
        System.out.println(solution.maxDepth("1"));

    }
}