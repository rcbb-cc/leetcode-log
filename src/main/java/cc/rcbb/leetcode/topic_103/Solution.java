package cc.rcbb.leetcode.topic_103;

import cc.rcbb.leetcode.template.TreeNode;

import javax.management.Query;
import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        boolean leftToFlag = true;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (leftToFlag) {
                    TreeNode curr = q.pollFirst();
                    list.add(curr.val);
                    if (curr.left == null && curr.right == null) {
                        continue;
                    }
                    if (curr.left != null) {
                        q.offer(curr.left);
                    }
                    if (curr.right != null) {
                        q.offer(curr.right);
                    }
                } else {
                    TreeNode curr = q.pollLast();
                    list.add(curr.val);
                    if (curr.left == null && curr.right == null) {
                        continue;
                    }
                    if (curr.right != null) {
                        q.offerFirst(curr.right);
                    }
                    if (curr.left != null) {
                        q.offerFirst(curr.left);
                    }
                }
            }
            leftToFlag = !leftToFlag;
            result.add(list);
        }
        return result;
    }


    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean leftToFlag = true;
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (leftToFlag) {
                    list.add(curr.val);
                } else {
                    list.addFirst(curr.val);
                }
                if (curr.left == null && curr.right == null) {
                    continue;
                }
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            leftToFlag = !leftToFlag;
            result.add(list);
        }
        return result;
    }
}