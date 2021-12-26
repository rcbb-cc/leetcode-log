package cc.rcbb.leetcode.topic_1609;

import cc.rcbb.leetcode.template.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1609. 奇偶树
 * https://leetcode-cn.com/problems/even-odd-tree/
 */
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean flag = true;
        while (!q.isEmpty()) {
            int size = q.size();
            int preVal = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                int val = curr.val;
                if (flag) {
                    // 必须是奇数，且严格递增
                    if (val % 2 == 0) {
                        return false;
                    }
                    if (preVal != 0 && val <= preVal) {
                        return false;
                    }
                } else {
                    // 必须是偶数，且严格递减
                    if (val % 2 != 0) {
                        return false;
                    }
                    if (preVal != 0 && val >= preVal) {
                        return false;
                    }
                }
                preVal = val;
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            flag = !flag;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();



    }
}