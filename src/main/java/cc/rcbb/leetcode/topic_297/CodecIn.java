package cc.rcbb.leetcode.topic_297;

import cc.rcbb.leetcode.template.TreeNode;

/**
 * 297. 二叉树的序列化与反序列化
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 *
 * 中序遍历无法实现，因为无法确定头节点的位置。
 */
public class CodecIn {

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
        sb.append(root.val).append(",");
        f(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data == "") {
            return null;
        }

        return null;
    }


}