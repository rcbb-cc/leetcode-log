package cc.rcbb.leetcode.topic_297;

import cc.rcbb.leetcode.common.RcbbPrinter;
import cc.rcbb.leetcode.template.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 297. 二叉树的序列化与反序列化
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 *
 * 层级遍历实现
 */
public class CodecBFS {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node == null) {
                    sb.append("#").append(",");
                    continue;
                }
                sb.append(node.val).append(",");
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return sb.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data == "") {
            return null;
        }
        String[] dataArray = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(dataArray[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        for (int i = 1; i < dataArray.length; ) {

            TreeNode node = q.poll();

            String left = dataArray[i++];
            if ("#".equals(left)) {
                node.left = null;
            } else {
                TreeNode leftNode = new TreeNode(Integer.parseInt(left));
                node.left = leftNode;
                q.offer(leftNode);
            }

            String right = dataArray[i++];
            if ("#".equals(right)) {
                node.right = null;
            } else {
                TreeNode rightNode = new TreeNode(Integer.parseInt(right));
                node.right = rightNode;
                q.offer(rightNode);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        CodecBFS codecBFS = new CodecBFS();
        String serialize = codecBFS.serialize(buildTree());
        System.out.println(serialize);
        TreeNode root = codecBFS.deserialize(serialize);
        RcbbPrinter.preOrderPrint(root);
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