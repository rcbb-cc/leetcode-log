package cc.rcbb.leetcode.topic_111;

import cc.rcbb.leetcode.template.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. 二叉树的最小深度
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
class Solution {

    /**
     * 递归
     */
    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth1(root.left);
        int right = minDepth1(root.right);

        if (left == 0 || right == 0) {
            return left + right + 1;
        }
        return left < right ? left + 1 : right + 1;
    }

    /**
     * BFS思想，广搜
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int step = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                if (cur.left == null && cur.right == null) {
                    return step;
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            step++;
        }
        return step;
    }
}