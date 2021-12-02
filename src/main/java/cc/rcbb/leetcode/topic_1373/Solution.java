package cc.rcbb.leetcode.topic_1373;

import cc.rcbb.leetcode.template.TreeNode;

/**
 * 1373. 二叉搜索子树的最大键值和
 * https://leetcode-cn.com/problems/maximum-sum-bst-in-binary-tree/
 */
class Solution {
    int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        traverse(root);
        return maxSum;
    }

    /**
     * 返回一个大小为 4 的 int 数组
     * res[0]：记录以root为根的二叉树是否是BST（1：是BST；0：不是）
     * res[1]：记录以root为根的二叉树所有节点中的最小值
     * res[2]：记录以root为根的二叉树所有节点中的最大值
     * res[3]：记录以root为根的二叉树所有的节点值之和
     */
    public int[] traverse(TreeNode root) {
        if (root == null) {
            return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int[] left = traverse(root.left);
        int[] right = traverse(root.right);
        // 后续遍历，计算
        int[] res = new int[4];
        // 左右子树都是BST
        if (left[0] == 1 && right[0] == 1
                // 并且当前的根节点的值，满足：大于左子树的最大值 && 小于右子树的最小值
                && root.val > left[2] && root.val < right[1]) {
            res[0] = 1;
            // 计算以root为根的这棵BST的最小值
            res[1] = Math.min(left[1], root.val);
            // 计算以root为根的这棵BST的最大值
            res[2] = Math.max(right[2], root.val);
            // 计算以root为根的这棵BST所有节点之和
            res[3] = left[3] + right[3] + root.val;
            // 更新全局变量
            maxSum = Math.max(maxSum, res[3]);
        } else {
            // 以root为根的二叉树不是BST
            res[0] = 0;
        }
        return res;
    }
}