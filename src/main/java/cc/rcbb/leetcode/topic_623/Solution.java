package cc.rcbb.leetcode.topic_623;

import cc.rcbb.leetcode.template.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 623. 在二叉树中增加一行
 * https://leetcode.cn/problems/add-one-row-to-tree/
 */
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            node.right = null;
            return node;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                if (level == depth - 1) {
                    TreeNode a = new TreeNode(val);
                    TreeNode b = new TreeNode(val);
                    a.left = t.left;
                    b.right = t.right;
                    t.left = a;
                    t.right = b;
                } else {
                    if (t.left != null) {
                        queue.add(t.left);
                    }
                    if (t.right != null) {
                        queue.add(t.right);
                    }
                }
            }
            level++;
        }
        return root;
    }

    public TreeNode addOneRow1(TreeNode root, int val, int depth) {
        if (root == null) {
            return null;
        }
        // 当输入的 depth 为 1 时，需要创建一个新的 root，将原 root 作为左节点
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        // 当输入的 depth 为 2 时，在 root 左节点和右节点新增节点
        if (depth == 2) {
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
        } else {
            // 当 depth 大于 2 时，需要继续递归往下层搜索，并将 depth 减去 1，直到搜索到 depth 为 2
            root.left = addOneRow1(root.left, val, depth - 1);
            root.right = addOneRow1(root.right, val, depth - 1);
        }
        return root;
    }
}