package cc.rcbb.leetcode.topic_230;

import cc.rcbb.leetcode.template.TreeNode;

/**
 * 230. 二叉搜索树中第K小的元素
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 */
class Solution {
    int res = 0;
    int rank = 0;

    public int kthSmallest(TreeNode root, int k) {
        f(root, k);
        return res;
    }

    public void f(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        f(root.left, k);
        System.out.println(root.val + " rank=" + rank + " k=" + k);
        rank++;
        if (rank == k) {
            res = root.val;
            return;
        }
        f(root.right, k);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int r = solution.kthSmallest(buildTree(), 4);
        System.out.println(r);
    }

    public static TreeNode buildTree() {
        TreeNode two = new TreeNode(2, null, null);
        TreeNode one = new TreeNode(1, null, two);
        TreeNode four = new TreeNode(4, null, null);
        TreeNode three = new TreeNode(3, one, four);
        return three;
    }
}