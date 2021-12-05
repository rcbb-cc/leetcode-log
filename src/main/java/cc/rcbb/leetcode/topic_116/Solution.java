package cc.rcbb.leetcode.topic_116;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 */
public class Solution {
    /**
     * 这么连接肯定是有问题的。
     * 节点 5 和节点 6 不属于同一个父节点，那么按照这段代码的逻辑，它俩就没办法被穿起来
     */
    public Node connect1(Node root) {
        if (root == null) {
            return null;
        }
        Node left = root.left;
        left.next = root.right;

        connect1(root.left);
        connect1(root.right);
        return root;
    }

    /**
     * 正确解法，需要额外依靠一个函数
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        connectTwoNode(root.left, root.right);
        return root;
    }


    void connectTwoNode(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        node1.next = node2;
        // 连接相同父节点的两个子节点
        connectTwoNode(node1.left, node1.right);
        connectTwoNode(node2.left, node2.right);
        // 连接跨越父节点的子节点
        connectTwoNode(node1.right, node2.left);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}