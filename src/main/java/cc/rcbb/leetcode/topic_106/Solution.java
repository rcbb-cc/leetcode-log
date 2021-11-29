package cc.rcbb.leetcode.topic_106;

import cc.rcbb.leetcode.template.TreeNode;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return f(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    public TreeNode f(int[] inorder, int inStart, int inEnd,
                      int[] postorder, int postStart, int postEnd) {
        if (postStart > postEnd) {
            return null;
        }
        // 头结点
        int rootVal = postorder[postEnd];

        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        int leftSize = index - inStart;
        TreeNode left = f(inorder, inStart, index - 1,
                postorder, postStart, postStart + leftSize - 1);
        TreeNode right = f(inorder, index + 1, inEnd,
                postorder, postStart + leftSize, postEnd - 1);
        root.left = left;
        root.right = right;
        return root;
    }
}