package cc.rcbb.leetcode.topic_1022;

import cc.rcbb.leetcode.template.TreeNode;

/**
 * 1022. 从根到叶的二进制数之和
 * https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/
 */
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return f(root, 0);
    }

    private int f(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = 2 * sum + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return f(root.left, sum) + f(root.right, sum);
    }
}