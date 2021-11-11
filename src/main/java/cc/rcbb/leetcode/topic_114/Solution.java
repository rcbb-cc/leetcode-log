package cc.rcbb.leetcode.topic_114;

import cc.rcbb.leetcode.template.TreeNode;

/**
 * 114. 二叉树展开为链表
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 */
public class Solution {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        // 后序遍历
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 左子树置空
        root.left = null;
        // 将左子树作为右子树
        root.right = left;
        // 将原先的右子树接到当前右子树的最后
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }
}