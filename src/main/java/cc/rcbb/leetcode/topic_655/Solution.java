package cc.rcbb.leetcode.topic_655;

import cc.rcbb.leetcode.template.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 655. 输出二叉树
 * https://leetcode.cn/problems/print-binary-tree/
 */
class Solution {

    class Tuple {
        TreeNode node;
        int r;
        int c;

        public Tuple(TreeNode node, int r, int c) {
            this.node = node;
            this.r = r;
            this.c = c;
        }
    }

    public List<List<String>> printTree(TreeNode root) {
        int height = calDepth(root);
        int m = height + 1;
        int n = (1 << (height + 1)) - 1;
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add("");
            }
            res.add(row);
        }
        Queue<Tuple> queue = new ArrayDeque<>();
        queue.offer(new Tuple(root, 0, (n - 1) / 2));
        while (!queue.isEmpty()) {
            Tuple t = queue.poll();
            TreeNode node = t.node;
            int r = t.r, c = t.c;
            res.get(r).set(c, Integer.toString(node.val));
            if (node.left != null) {
                queue.offer(new Tuple(node.left, r + 1, c - (1 << (height - r - 1))));
            }
            if (node.right != null) {
                queue.offer(new Tuple(node.right, r + 1, c + (1 << (height - r - 1))));
            }
        }
        return res;
    }

    private int calDepth(TreeNode root) {
        int res = -1;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            while (size > 0) {
                size--;
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return res;
    }


}