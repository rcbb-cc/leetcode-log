package cc.rcbb.leetcode.topic_1021;


/**
 * 1021. 删除最外层的括号
 * https://leetcode.cn/problems/remove-outermost-parentheses/
 */
class Solution1 {
    public String removeOuterParentheses(String s) {
        int level = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                level--;
            }
            if (level > 0) {
                sb.append(c);
            }
            if (c == '(') {
                level++;
            }
        }
        return sb.toString();
    }
}