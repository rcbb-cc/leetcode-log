package cc.rcbb.leetcode.topic_732;

/**
 * 732. 我的日程安排表 III
 * https://leetcode.cn/problems/my-calendar-iii/
 */
class MyCalendarThree {

    static class Node {
        private int left;
        private int right;
        private int max;
        private int lazy;

        Node leftChild;
        Node rightChild;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public void update(Node root, int left, int right, int value) {
        if (root.left > right || root.right < left) {
            return;
        }
        if (root.left >= left && root.right <= right) {
            root.max += value;
            root.lazy += value;
        } else {
            lazyCreate(root);
            pushDown(root);
            update(root.leftChild, left, right, value);
            update(root.rightChild, left, right, value);
            pushUp(root);
        }
    }

    public void lazyCreate(Node root) {
        if (root.leftChild == null) {
            root.leftChild = new Node(root.left, root.left + (root.right - root.left) / 2);
        }
        if (root.rightChild == null) {
            root.rightChild = new Node(root.left + (root.right - root.left) / 2 + 1, root.right);
        }
    }

    public void pushDown(Node root) {
        if (root.lazy > 0) {
            root.leftChild.max += root.lazy;
            root.leftChild.lazy += root.lazy;
            root.rightChild.max += root.lazy;
            root.rightChild.lazy += root.lazy;
            root.lazy = 0;
        }
    }

    public void pushUp(Node root) {
        root.max = Math.max(root.leftChild.max, root.rightChild.max);
    }

    private Node root;

    public MyCalendarThree() {
        root = new Node(0, (int) (1e9));
    }

    public int book(int start, int end) {
        update(root, start, end - 1, 1);
        return root.max;
    }
}