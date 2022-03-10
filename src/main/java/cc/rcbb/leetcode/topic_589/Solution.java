package cc.rcbb.leetcode.topic_589;

import java.util.ArrayList;
import java.util.List;

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
 * 589. N 叉树的前序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 */
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        f(root, res);
        return res;
    }

    private void f(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);

        for (Node r : root.children) {
            f(r, res);
        }
    }
}