package cc.rcbb.leetcode.topic_94;

import cc.rcbb.leetcode.template.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrderTraverse(result, root);
        return result;
    }

    public void inOrderTraverse(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraverse(result, root.left);
        result.add(root.val);
        inOrderTraverse(result, root.right);
    }
}