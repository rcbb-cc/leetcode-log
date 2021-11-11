package cc.rcbb.leetcode.template;

import java.util.LinkedList;

/**
 * 写树相关的算法，简单说就是，
 * 先搞清楚当前 root 节点「该做什么」以及「什么时候做」，
 * 然后根据函数定义递归调用子节点，递归调用会让孩子节点做相同的事情。
 */
public class BinaryTreeTemplate {

    public static TreeNode create(LinkedList<Integer> list) {

        return null;
    }

    /**
     * 二叉树前序遍历   根-> 左-> 右
     */
    public static void preOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val);
        preOrderTraverse(root.left);
        preOrderTraverse(root.right);
    }

    /**
     * 二叉树中序遍历   左-> 根-> 右
     */
    public static void inOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraverse(root.left);
        System.out.print(root.val);
        inOrderTraverse(root.right);
    }

    /**
     * 二叉树后序遍历   左-> 右-> 根
     */
    public static void postOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraverse(root.left);
        postOrderTraverse(root.right);
        System.out.print(root.val);
    }

    /**
     * 二叉树遍历
     */
    void traverse(TreeNode root) {
        // 前序遍历
        traverse(root.left);
        // 中序遍历
        traverse(root.right);
        // 后续遍历
    }

}
