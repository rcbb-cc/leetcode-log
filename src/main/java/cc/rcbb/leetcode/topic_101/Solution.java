package cc.rcbb.leetcode.topic_101;

import cc.rcbb.leetcode.template.TreeNode;

/**
 * 101. 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root, root);
    }

    public boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        int pi = p.val;
        int qi = q.val;
        if (pi != qi) {
            return false;
        }
        return dfs(p.left, q.right) && dfs(p.right, q.left);
    }
}