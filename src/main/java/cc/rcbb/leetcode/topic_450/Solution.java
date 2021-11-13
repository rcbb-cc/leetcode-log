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
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            if (root.left != null && root.right != null) {
                TreeNode p = root.right;
                while (p.left != null) {
                    p = p.left;
                }
                root.val = p.val;
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