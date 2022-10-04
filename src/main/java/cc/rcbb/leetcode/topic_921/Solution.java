package cc.rcbb.leetcode.topic_921;

import java.util.Stack;

/**
 * 921. 使括号有效的最少添加
 * https://leetcode.cn/problems/minimum-add-to-make-parentheses-valid/
 */
class Solution {
    /**
     * 有效括号问题 转换为 分值有效性
     * score，将 '(' 记为 +1，将 ')' 记为 -1
     * 一个有效的括号应当在整个过程中不出现负数，因此一旦 score 出现负数，
     * 需要马上增加 ')' 来保证合法性。
     *
     * @param s
     * @return
     */
    public int minAddToMakeValid(String s) {
        int score = 0;
        int count = 0;
        for (char c : s.toCharArray()) {
            score += c == '(' ? 1 : -1;
            if (score < 0) {
                score = 0;
                count++;
            }
        }
        return count + score;
    }

    public int minAddToMakeValid1(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minAddToMakeValid("())"));
        System.out.println(solution.minAddToMakeValid("((("));
    }
}