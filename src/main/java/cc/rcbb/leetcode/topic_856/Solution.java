package cc.rcbb.leetcode.topic_856;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 856. 括号的分数
 * https://leetcode.cn/problems/score-of-parentheses/
 */
class Solution {
    public int scoreOfParentheses(String s) {
        Deque<Integer> st = new ArrayDeque<>();
        st.push(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(0);
            } else {
                int v = st.pop();
                int top = st.pop() + Math.max(2 * v, 1);
                st.push(top);
            }
        }
        return st.peek();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.scoreOfParentheses("(()())"));
    }
}