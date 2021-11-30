package cc.rcbb.leetcode.topic_652;

import cc.rcbb.leetcode.template.TreeNode;

import java.util.*;

/**
 * 652. 寻找重复的子树
 * https://leetcode-cn.com/problems/find-duplicate-subtrees/
 */
class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Map<String, Integer> memo = new HashMap<>();
        f(root, memo, result);
        return result;
    }

    public String f(TreeNode root, Map<String, Integer> memo, List<TreeNode> result) {
        if (root == null) {
            return "#";
        }
        String left = f(root.left, memo, result);
        String right = f(root.right, memo, result);
        int val = root.val;
        String s = left + "," + right + "," + val;
        Integer existVal = memo.getOrDefault(s, 0);
        if (existVal == 1) {
            result.add(root);
        }
        memo.put(s, memo.getOrDefault(s, 0) + 1);
        return s;
    }
}