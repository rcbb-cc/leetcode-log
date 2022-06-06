package cc.rcbb.leetcode.topic_450;

import cc.rcbb.leetcode.template.TreeNode;

/**
 * 450. 删除二叉搜索树中的节点
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/
 */
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }
            // 只有右子树
            if (root.left == null) {
                return root.right;
            }
            // 只有左子树
            if (root.right == null) {
                return root.left;
            }
            // 有左右子树
            if (root.left != null && root.right != null) {
                // 找出右子树的最左子节点
                TreeNode p = root.right;
                while (p.left != null) {
                    p = p.left;
                }
                // 将右子树最小值替换到该子树根节点
                root.val = p.val;
                // 然后再删除这个值
                root.right = deleteNode(root.right, p.val);
            }
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
}