package cc.rcbb.leetcode.topic_606;

import cc.rcbb.leetcode.template.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * 606. 根据二叉树创建字符串
 * https://leetcode-cn.com/problems/construct-string-from-binary-tree/
 */
class Solution2 {
    public String tree2str(TreeNode root) {
        StringBuilder result = new StringBuilder();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        Set<TreeNode> visited = new HashSet<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (!visited.add(node)) {
                if (node != root) {
                    result.append(")");
                }
                stack.pop();
            } else {
                if (node != root) {
                    result.append("(");
                }
                result.append(node.val);
                if (node.left == null && node.right != null) {
                    result.append("()");
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
        return result.toString();
    }
}