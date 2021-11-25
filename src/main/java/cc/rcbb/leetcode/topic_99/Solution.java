package cc.rcbb.leetcode.topic_99;

import cc.rcbb.leetcode.template.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 99. 恢复二叉搜索树
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 */
class Solution {
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        // 中序遍历，将树放入List中
        dfs(root, list);
        TreeNode x = null;
        TreeNode y = null;
        for (int i = 0; i < list.size() - 1; i++) {
            // 取到两个有数据问题的节点
            if (list.get(i).val > list.get(i + 1).val) {
                // y取后面一个有问题的节点
                y = list.get(i + 1);
                if (x == null) {
                    // x取前面一个有问题的节点
                    x = list.get(i);
                }
            }
        }
        if (x != null && y != null) {
            // 将两个节点的值，调换一下
            int temp = x.val;
            x.val = y.val;
            y.val = temp;
        }
    }

    public void dfs(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root);
        dfs(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode one = new TreeNode(1);
        one.left = three;
        three.right = two;
        Solution solution = new Solution();
        solution.recoverTree(one);

    }

}