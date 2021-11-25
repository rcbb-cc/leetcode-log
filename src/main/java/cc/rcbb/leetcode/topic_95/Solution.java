package cc.rcbb.leetcode.topic_95;

import cc.rcbb.leetcode.common.RcbbPrinter;
import cc.rcbb.leetcode.template.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>(0);
        if (n == 0) {
            return result;
        }
        return generate(1, n);
    }

    public List<TreeNode> generate(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        // 没有数字，添加null
        if (start > end) {
            result.add(null);
            return result;
        }
        // 只有一个数字，当前数字作为一棵树添加
        if (start == end) {
            result.add(new TreeNode(start));
            return result;
        }
        // 尝试每个数字作为根节点
        for (int i = start; i <= end; i++) {
            // 得到所有可能的左子树
            List<TreeNode> leftTrees = generate(start, i - 1);
            // 得到所有可能的右子树
            List<TreeNode> rightTrees = generate(i + 1, end);
            // 左子树和右子树，两两组合
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    result.add(root);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        List<TreeNode> treeNodes = solution.generateTrees(3);
        for (int i = 0; i < treeNodes.size(); i++) {
            RcbbPrinter.preOrderPrint(treeNodes.get(i));
            System.out.println();
        }
    }
}