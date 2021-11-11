package cc.rcbb.leetcode.common;

import cc.rcbb.leetcode.template.BinaryTreeTemplate;
import cc.rcbb.leetcode.template.TreeNode;

import java.util.List;

/**
 * <p>
 * Printer
 * </p>
 *
 * @author lvhao
 * @date 2021/11/3
 */
public class RcbbPrinter {

    public static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void print(List<Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            System.out.print(nums.get(i) + " ");
        }
        System.out.println();
    }

    /**
     * 二叉树的前序遍历
     */
    public static void preOrderPrint(TreeNode root) {
        BinaryTreeTemplate.preOrderTraverse(root);
    }

    /**
     * 二叉树的中序遍历
     */
    public static void inOrderPrint(TreeNode root) {
        BinaryTreeTemplate.inOrderTraverse(root);
    }

    /**
     * 二叉树的后序遍历
     */
    public static void postOrderPrint(TreeNode root) {
        BinaryTreeTemplate.postOrderTraverse(root);
    }


}
