package cc.rcbb.leetcode.topic_653;

import cc.rcbb.leetcode.template.TreeNode;

import java.util.*;

/**
 * 653. 两数之和 IV - 输入 BST
 * https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
 */
class Solution {
    Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}