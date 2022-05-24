package cc.rcbb.leetcode.topic_965;

import cc.rcbb.leetcode.template.TreeNode;

/**
 * 965. 单值二叉树
 * https://leetcode.cn/problems/univalued-binary-tree/
 */
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        return f(root, root.val);
    }

    private boolean f(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        if (root.val != val) {
            return false;
        }
        return f(root.left, val) && f(root.right, val);
    }
}