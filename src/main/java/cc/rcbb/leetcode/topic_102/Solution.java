package cc.rcbb.leetcode.topic_102;

import cc.rcbb.leetcode.template.BFSTemplate;
import cc.rcbb.leetcode.template.TreeNode;

import java.util.*;

/**
 * 102. 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int sz = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                list.add(cur.val);
                if (cur.left == null && cur.right == null) {
                    continue;
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode treeNode = buildTree();
        solution.levelOrder(treeNode);
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