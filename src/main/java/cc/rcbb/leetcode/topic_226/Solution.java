package cc.rcbb.leetcode.topic_226;


import cc.rcbb.leetcode.common.RcbbPrinter;
import cc.rcbb.leetcode.template.BinaryTreeTemplate;
import cc.rcbb.leetcode.template.TreeNode;

import java.util.LinkedList;

/**
 * 226. 翻转二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /**
     * 输入：
     *
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * 输出：
     *
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     */

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = buildTree();

        RcbbPrinter.preOrderPrint(root);
        System.out.println();

        solution.invertTree(root);
        RcbbPrinter.preOrderPrint(root);

        System.out.println();
        RcbbPrinter.inOrderPrint(root);
        System.out.println();
        RcbbPrinter.postOrderPrint(root);

    }


    private static TreeNode buildTree() {
        TreeNode one = new TreeNode();
        one.val = 1;
        one.left = null;
        one.right = null;
        TreeNode three = new TreeNode();
        three.val = 3;
        three.left = null;
        three.right = null;
        TreeNode two = new TreeNode();
        two.val = 2;
        two.left = one;
        two.right = three;

        TreeNode six = new TreeNode();
        six.val = 6;
        six.left = null;
        six.right = null;
        TreeNode nine = new TreeNode();
        nine.val = 9;
        nine.left = null;
        nine.right = null;
        TreeNode seven = new TreeNode();
        seven.val = 7;
        seven.left = six;
        seven.right = nine;

        TreeNode four = new TreeNode();
        four.val = 4;
        four.left = two;
        four.right = seven;
        return four;
    }
}
