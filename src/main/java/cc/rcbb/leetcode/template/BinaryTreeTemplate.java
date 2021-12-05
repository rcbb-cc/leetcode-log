package cc.rcbb.leetcode.template;

import java.util.*;

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
     * 递归
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
     * 递归
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
     * 递归
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
     * 递归
     * 层序遍历
     */
    public void levelOrderTraverse(TreeNode root, int i, List list) {
        if (root == null) {
            return;
        }
        int size = list.size();
        // 防止报错，List.set时，如果size小于或等于i，IndexOutOfBoundsException
        if (size <= i) {
            for (int j = 0; j <= i - size; j++) {
                list.add(size + j, null);
            }
        }
        list.set(i, root.val);
        System.out.println(Arrays.toString(list.toArray()));
        levelOrderTraverse(root.left, 2 * i, list);
        levelOrderTraverse(root.right, 2 * i + 1, list);
    }

    /**
     * 迭代
     * 前序遍历
     */
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            root = s.pop();
            result.add(root.val);
            // 为什么先加right，后加left，因为要将left放栈顶
            if (root.right != null) {
                s.push(root.right);
            }
            if (root.left != null) {
                s.push(root.left);
            }
        }
        System.out.println(Arrays.toString(result.toArray()));
    }

    /**
     * 迭代
     * 中序遍历
     */
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        while (!s.isEmpty() || root != null) {
            while (root != null) {
                // 先到最左边
                s.push(root);
                root = root.left;
            }
            if (!s.isEmpty()) {
                // 到了最左边
                root = s.pop();
                result.add(root.val);
                // 让root
                root = root.right;
            }
        }
        System.out.println(Arrays.toString(result.toArray()));
    }

    /**
     * 迭代
     * 后序遍历
     */
    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            // 因为出栈顺序为“根右左”，所以需要每次将元素插入list开头
            result.add(0, node.val);
            if (node.left != null) {
                s.push(node.left);
            }
            if (node.right != null) {
                s.push(node.right);
            }
        }
        System.out.println(Arrays.toString(result.toArray()));
    }


    /**
     * 最小深度
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        // 特殊情况：空的叶子节点不算，所以遇到空叶子节点，需要排除，或者两个叶子结点都为空。
        if (left == 0 || right == 0) {
            return left + right + 1;
        }
        return left < right ? left + 1 : right + 1;
    }

    /**
     * 最大深度
     */
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


    public static void main(String[] args) {
        BinaryTreeTemplate template = new BinaryTreeTemplate();
        template.preOrder(buildTree());
        template.inOrder(buildTree());
        template.postOrder(buildTree());
    }

    public static TreeNode buildTree() {
        TreeNode two = new TreeNode(2, null, null);
        TreeNode one = new TreeNode(1, null, two);
        TreeNode four = new TreeNode(4, null, null);
        TreeNode three = new TreeNode(3, one, four);
        return three;
    }

}
