package cc.rcbb.leetcode.topic_662;

import cc.rcbb.leetcode.template.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 662. 二叉树最大宽度
 * https://leetcode.cn/problems/maximum-width-of-binary-tree/
 */
class Solution {

    class MyNode {
        TreeNode node;
        int index;

        MyNode(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;

        Queue<MyNode> queue = new LinkedList<>();
        queue.offer(new MyNode(root, 1));
        while (!queue.isEmpty()) {
            int size = queue.size();
            int min = -1, max = -1;
            while (size-- > 0) {
                MyNode node = queue.poll();
                if (min == -1) {
                    min = node.index;
                }
                max = node.index;

                if (node.node.left != null) {
                    queue.offer(new MyNode(node.node.left, 2 * node.index));
                }
                if (node.node.right != null) {
                    queue.offer(new MyNode(node.node.right, 2 * node.index + 1));
                }
            }
            ans = Math.max(ans, max - min + 1);
        }
        return ans;
    }
}