package cc.rcbb.leetcode.topic_105;

import cc.rcbb.leetcode.template.TreeNode;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return f(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    public TreeNode f(int[] preorder, int preStart, int preEnd,
                      int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        // root节点为前序的第一个元素
        int rootVal = preorder[preStart];
        // 根据rootVal获取在中序中的索引
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        int leftSize = index - inStart;
        // 画图，找前序和中序，下标对应关系
        TreeNode left = f(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, index - 1);
        TreeNode right = f(preorder, preStart + leftSize + 1, preEnd,
                inorder, index + 1, inEnd);
        root.left = left;
        root.right = right;
        return root;
    }
}