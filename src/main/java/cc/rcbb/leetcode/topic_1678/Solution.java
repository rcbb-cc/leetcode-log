package cc.rcbb.leetcode.topic_1678;

/**
 * 1678. 设计 Goal 解析器
 * https://leetcode.cn/problems/goal-parser-interpretation/
 * <p>
 * 模拟
 */
class Solution {
    public String interpret(String command) {
        command = command.replaceAll("\\(\\)", "o");
        command = command.replaceAll("\\(al\\)", "al");
        return command;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.interpret("G()(al)"));
        System.out.println(solution.interpret("G()()()()(al)"));
        System.out.println(solution.interpret("(al)G(al)()()G"));
    }
}