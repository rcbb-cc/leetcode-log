package cc.rcbb.leetcode.topic_04_06;

import cc.rcbb.leetcode.template.TreeNode;

/**
 * 面试题 04.06. 后继者
 * https://leetcode.cn/problems/successor-lcci/
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        if (p.val >= root.val) {
            // 在右子树
            return inorderSuccessor(root.right, p);
        }
        // 在左子树
        TreeNode res = inorderSuccessor(root.left, p);
        // 左子树若为 null，其后继者就是 root
        return res == null ? root : res;
    }

}