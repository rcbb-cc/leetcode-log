package cc.rcbb.leetcode.topic_297;

import cc.rcbb.leetcode.common.RcbbPrinter;
import cc.rcbb.leetcode.template.TreeNode;

import java.util.LinkedList;

/**
 * 297. 二叉树的序列化与反序列化
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 *
 * 后序遍历的方式实现
 */
public class CodecPost {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        f(root, sb);
        return sb.toString();
    }

    public void f(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#").append(",");
            return;
        }

        f(root.left, sb);
        f(root.right, sb);
        sb.append(root.val).append(",");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data == "") {
            return null;
        }
        LinkedList<String> nodes = new LinkedList<>();
        for (String node : data.split(",")) {
            nodes.add(node);
        }
        return f(nodes);
    }

    public TreeNode f(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        // 因为是后序遍历，头节点在最后
        String rootVal = nodes.pollLast();
        if ("#".equals(rootVal)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(rootVal));
        // 注意：后续的特点，左子树右子树头结点
        // 所以从后往前，先是右子树
        root.right = f(nodes);
        root.left = f(nodes);
        return root;
    }

    public static void main(String[] args) {
        CodecPost codecPost = new CodecPost();
        String traverse = codecPost.serialize(buildTree());
        System.out.println(traverse);
        TreeNode root = codecPost.deserialize(traverse);
        RcbbPrinter.postOrderPrint(root);
    }


    private static TreeNode buildTree() {

        TreeNode one = new TreeNode();
        one.val = 1;
        one.left = null;
        one.right = null;
        TreeNode two = new TreeNode();
        two.val = 2;
        two.left = one;
        two.right = null;
        return two;
        /*TreeNode one = new TreeNode();
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
        return four;*/
    }

}