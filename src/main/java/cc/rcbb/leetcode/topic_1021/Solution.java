package cc.rcbb.leetcode.topic_1021;

import java.util.Stack;

/**
 * 1021. 删除最外层的括号
 * https://leetcode.cn/problems/remove-outermost-parentheses/
 */
class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                sb.append(c);
            }
            if (c == '(') {
                stack.push(c);
            }
        }
        return sb.toString();
    }
}