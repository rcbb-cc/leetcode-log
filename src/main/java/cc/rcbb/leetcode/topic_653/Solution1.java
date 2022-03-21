package cc.rcbb.leetcode.topic_653;

import cc.rcbb.leetcode.template.TreeNode;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * 653. 两数之和 IV - 输入 BST
 * https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
 */
class Solution1 {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        Set<Integer> set = new HashSet<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (set.contains(k - node.val)) {
                return true;
            }
            set.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return false;
    }
}