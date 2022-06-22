package cc.rcbb.leetcode.topic_513;

import cc.rcbb.leetcode.template.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 513. 找树左下角的值
 * https://leetcode.cn/problems/find-bottom-left-tree-value/
 */
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            res = node.val;
        }
        return res;
    }
}