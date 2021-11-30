package cc.rcbb.leetcode.topic_297;

import cc.rcbb.leetcode.common.RcbbPrinter;
import cc.rcbb.leetcode.template.TreeNode;

import java.util.LinkedList;

/**
 * 297. 二叉树的序列化与反序列化
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 *
 * 前序遍历的方式实现
 */
public class CodecPre {

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
        sb.append(root.val).append(",");
        f(root.left, sb);
        f(root.right, sb);
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

        String rootVal = nodes.pollFirst();
        if ("#".equals(rootVal)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(rootVal));
        root.left = f(nodes);
        root.right = f(nodes);
        return root;
    }



    public static void main(String[] args) {
        CodecPre codecPre = new CodecPre();
        String traverse = codecPre.serialize(buildTree());
        System.out.println(traverse);
        TreeNode root = codecPre.deserialize(traverse);
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
