package cc.rcbb.leetcode.topic_1302;

import cc.rcbb.leetcode.template.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1302. 层数最深叶子节点的和
 * https://leetcode.cn/problems/deepest-leaves-sum/
 */
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return sum;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            sum = 0;
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node != null) {
                    sum += node.val;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return sum;
    }
}