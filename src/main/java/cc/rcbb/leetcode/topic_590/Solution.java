package cc.rcbb.leetcode.topic_590;

import java.util.ArrayList;
import java.util.List;


// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

/**
 * 590. N 叉树的后序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        f(root, res);
        return res;
    }

    private void f(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        for (Node n : root.children) {
            f(n, res);
        }
        res.add(root.val);
    }
}