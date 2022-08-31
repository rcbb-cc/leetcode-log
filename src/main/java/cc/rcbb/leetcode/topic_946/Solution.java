package cc.rcbb.leetcode.topic_946;

import java.util.Stack;

/**
 * 946. 验证栈序列
 * https://leetcode.cn/problems/validate-stack-sequences/
 */
class Solution {
    /**
     * 自己写的版本
     * 区别在于首先入栈，再while，即可得出下面的版本
     *
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int m = pushed.length;
        int n = popped.length;
        int i = 0, j = 0;
        while (i < m && j < n) {
            while (!stack.isEmpty() && stack.peek().equals(popped[j])) {
                stack.pop();
                j++;
            }
            stack.push(pushed[i++]);
        }
        while (!stack.isEmpty() && stack.peek().equals(popped[j])) {
            stack.pop();
            j++;
        }
        return stack.isEmpty() && j == n;
    }

    public boolean validateStackSequences1(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int n = pushed.length;
        for (int i = 0, j = 0; i < n; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
        // 输出：true
        System.out.println(solution.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
        // 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
        // 输出：false
        System.out.println(solution.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
    }
}