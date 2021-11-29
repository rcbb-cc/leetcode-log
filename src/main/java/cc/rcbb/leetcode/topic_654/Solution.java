package cc.rcbb.leetcode.topic_654;

import cc.rcbb.leetcode.common.RcbbPrinter;
import cc.rcbb.leetcode.template.TreeNode;

/**
 * 654. 最大二叉树
 * https://leetcode-cn.com/problems/maximum-binary-tree/
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return f(nums, 0, nums.length - 1);
    }

    public TreeNode f(int[] nums, int start, int end) {
        // 开始下标大于结束下标，错误
        if (start > end) {
            return null;
        }
        // 找出最大值
        Integer max = -1;
        // 裁切为两半
        int k = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                k = i;
                max = nums[i];
            }
        }
        TreeNode root = new TreeNode(max);
        TreeNode left = f(nums, start, k - 1);
        TreeNode right = f(nums, k + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        /**
         * 0  1  2  3  4  5
         * 3, 2, 1, 6, 0, 5
         *       0-5
         *    0-2    4-5
         * 0-0 1-2  4-4 5-5
         */
        int[] nums = new int[]{3, 2, 1, 6, 0, 5};
        //int[] nums = new int[]{3, 2, 1};

        TreeNode node = solution.constructMaximumBinaryTree(nums);
        RcbbPrinter.preOrderPrint(node);
    }
}