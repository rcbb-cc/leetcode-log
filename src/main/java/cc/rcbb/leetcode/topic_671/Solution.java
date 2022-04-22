package cc.rcbb.leetcode.topic_671;

import cc.rcbb.leetcode.template.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 671. 二叉树中第二小的节点
 * https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree
 */
class Solution {
    Set<Integer> set = new HashSet<>();

    public int findSecondMinimumValue(TreeNode root) {
        dfs(root);
        if (set.size() < 2) {
            return -1;
        }
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int i : set) {
            if (i <= first) {
                second = first;
                first = i;
            } else if (i <= second) {
                second = i;
            }
        }
        return second;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        set.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}