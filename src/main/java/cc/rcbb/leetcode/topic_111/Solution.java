package cc.rcbb.leetcode.topic_111;

import cc.rcbb.leetcode.template.TreeNode;

/**
 * 111. 二叉树的最小深度
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
class Solution {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if (left == 0 || right == 0) {
            return left + right + 1;
        }
        return left < right ? left + 1 : right + 1;
    }
}