package cc.rcbb.leetcode.template;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉搜索树（Binary Search Tree，简称：BST）
 * 特殊点：左小右大
 */
public class BSTTemplate {


    /**
     * 判断BST的合法性
     */
    boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /**
     * 限定以root为根的子树节点必须满足：
     * max.val > root.val > min.val
     */
    boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }

    /**
     * 在BST中搜索一个树
     * 类似二分查找思想
     */
    boolean isInBST(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.val < target) {
            return isInBST(root.right, target);
        }
        if (root.val > target) {
            return isInBST(root.left, target);
        }
        return true;
    }

    TreeNode searchBST(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        if (root.val < target) {
            return searchBST(root.right, target);
        }
        if (root.val > target) {
            return searchBST(root.left, target);
        }
        return root;
    }

    /**
     * 在BST中插入一个数
     */
    TreeNode insertIntoBST(TreeNode root, int val) {
        // 找到空位置插入新节点
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val == val) {
            // BST一般不会插入已经存在元素
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }

    TreeNode deleteNode(TreeNode root, int key) {
        if (root.val == key) {
            // 找到了，删除
            // 情况1：恰好是末端节点，两个子节点都为空
            if (root.left == null && root.right == null) {
                return null;
            }
            // 情况2：只有一个非空子节点，那么它的孩子接替位置
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // 情况3：有两个非空子节点，为了不破坏BST的性质，必须找出左子树中最大的那个节点，或者，
            // 右子树中最小的那个节点
            if (root.left != null && root.right != null) {
                // 找到右子树最小的节点
                TreeNode minNode = getMin(root.right);
                // 把root改成minNode
                root.val = minNode.val;
                // 转而去删除minNode
                root.right = deleteNode(root.right, minNode.val);
            }
        } else if (root.val > key) {
            // 去左子树找
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            // 去右子树找
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private TreeNode getMin(TreeNode root) {
        // BST最左边的就是最小的
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }


    /**
     * 二叉树最小深度
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
