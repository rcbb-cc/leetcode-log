package cc.rcbb.leetcode.topic_779;

/**
 * 779. 第K个语法符号
 * https://leetcode.cn/problems/k-th-symbol-in-grammar/submissions/
 */
class Solution {
    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (k & 1) ^ 1 ^ kthGrammar(n - 1, (k + 1) / 2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // System.out.println(solution.kthGrammar(1, 1));
        // System.out.println(solution.kthGrammar(2, 1));
        System.out.println(solution.kthGrammar(2, 2));
    }
}