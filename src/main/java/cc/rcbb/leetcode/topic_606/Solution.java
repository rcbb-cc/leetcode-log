package cc.rcbb.leetcode.topic_606;

import cc.rcbb.leetcode.template.TreeNode;

/**
 * 606. 根据二叉树创建字符串
 * https://leetcode-cn.com/problems/construct-string-from-binary-tree/
 */
class Solution {
    public String tree2str(TreeNode root) {
        StringBuilder result = new StringBuilder();
        f(root, result);
        String res = result.substring(1, result.length() - 1);
        return res;
    }

    public void f(TreeNode root, StringBuilder res) {
        if (root == null) {
            return;
        }
        res.append("(");
        res.append(root.val);
        if (root.left == null && root.right != null) {
            res.append("()");
        }
        f(root.left, res);
        f(root.right, res);
        res.append(")");
    }
}