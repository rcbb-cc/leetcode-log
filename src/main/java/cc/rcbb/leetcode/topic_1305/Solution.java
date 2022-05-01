package cc.rcbb.leetcode.topic_1305;

import cc.rcbb.leetcode.template.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 1305. 两棵二叉搜索树中的所有元素
 * https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees/
 */
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new LinkedList<>();
        f(root1, result);
        f(root2, result);
        Collections.sort(result);
        return result;
    }

    public void f(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        f(root.left, result);
        f(root.right, result);
    }
}