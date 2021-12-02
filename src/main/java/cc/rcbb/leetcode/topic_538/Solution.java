package cc.rcbb.leetcode.topic_538;

import cc.rcbb.leetcode.template.TreeNode;

/**
 * 538. 把二叉搜索树转换为累加树
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 */
class Solution {
    public TreeNode convertBST(TreeNode root) {
        f(root);
        return root;
    }

    int sum = 0;

    public void f(TreeNode root) {
        if (root == null) {
            return;
        }
        f(root.right);
        sum = root.val + sum;
        root.val = sum;
        f(root.left);
    }
}