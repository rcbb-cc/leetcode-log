package cc.rcbb.leetcode.topic_22;

import cc.rcbb.leetcode.common.RcbbPrinter;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 22. 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
class Solution {
    private List<String> result = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        int length = n * 2;
        char[] arr = new char[]{'(',')'};
        backtrack("", length, arr);
        return result;
    }


    public void backtrack(String s, int length, char[] arr) {
        if (s.length() == length) {
            if (check(s)) {
                result.add(s);
            }
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            s += arr[i];
            backtrack(s, length, arr);
            s = s.substring(0, s.length()-1);
        }
    }

    public boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                Character peek = stack.peek();
                if ((peek == '(' && s.charAt(i) == ')')) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<String> list = solution.generateParenthesis(3);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }


}