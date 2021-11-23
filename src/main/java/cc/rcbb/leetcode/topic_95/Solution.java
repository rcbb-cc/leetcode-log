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
        if (start > end) {
            result.add(null);
            return result;
        }
        if (start == end) {
            result.add(new TreeNode(start));
            return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generate(start, i - 1);
            List<TreeNode> rightTrees = generate(i + 1, end);
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