package cc.rcbb.leetcode.topic_449;

import cc.rcbb.leetcode.template.TreeNode;

import java.util.LinkedList;

/**
 * 449. 序列化和反序列化二叉搜索树
 * https://leetcode.cn/problems/serialize-and-deserialize-bst/
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        f(root, sb);
        return sb.toString();
    }

    private void f(TreeNode root, StringBuilder sb) {
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
        if (data == null || "".equals(data)) {
            return null;
        }
        LinkedList<String> nodes = new LinkedList<>();
        for (String node : data.split(",")) {
            nodes.add(node);
        }
        return f(nodes);
    }

    private TreeNode f(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        String node = nodes.pollFirst();
        if ("#".equals(node)) {
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.valueOf(node));
        treeNode.left = f(nodes);
        treeNode.right = f(nodes);
        return treeNode;
    }
}
