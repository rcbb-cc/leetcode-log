package cc.rcbb.leetcode.topic_699;

import cc.rcbb.leetcode.common.RcbbPrinter;

import java.util.ArrayList;
import java.util.List;

/**
 * 699. 掉落的方块
 * https://leetcode.cn/problems/falling-squares/
 */
class Solution1 {

    int N = (int) 1e9;

    class Node {
        // 当前区间的左子节点
        Node ls;
        // 当前区间的右子节点
        Node rs;
        // 当前区间最大高度
        int val;
        // 懒标记
        int add;
    }

    Node root = new Node();

    void update(Node node, int lc, int rc, int l, int r, int x) {
        if (l <= lc && rc <= r) {
            node.add = x;
            node.val = x;
            return;
        }
        pushdown(node);
        int mid = lc + rc >> 1;
        if (l <= mid) {
            update(node.ls, lc, mid, l, r, x);
        }
        if (r > mid) {
            update(node.rs, mid + 1, rc, l, r, x);
        }
        pushup(node);
    }

    int query(Node node, int lc, int rc, int l, int r) {
        if (l <= lc && rc <= r) {
            return node.val;
        }
        pushdown(node);
        int mid = lc + rc >> 1;
        int ans = 0;
        if (l <= mid) {
            ans = query(node.ls, lc, mid, l, r);
        }
        if (r > mid) {
            ans = Math.max(ans, query(node.rs, mid + 1, rc, l, r));
        }
        return ans;
    }

    void pushdown(Node node) {
        if (node.ls == null) {
            node.ls = new Node();
        }
        if (node.rs == null) {
            node.rs = new Node();
        }
        if (node.add == 0) {
            return;
        }
        node.ls.add = node.add;
        node.rs.add = node.add;
        node.ls.val = node.add;
        node.rs.val = node.add;
        node.add = 0;
    }

    void pushup(Node node) {
        node.val = Math.max(node.ls.val, node.rs.val);
    }

    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        for (int[] position : positions) {
            int x = position[0], h = position[1];
            int cur = query(root, 0, N, x, x + h - 1);
            update(root, 0, N, x, x + h - 1, cur + h);
            ans.add(root.val);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        // 输入: [[1, 2], [2, 3], [6, 1]]
        // 输出: [2, 5, 5]
        RcbbPrinter.print(solution.fallingSquares(new int[][]{{1, 2}, {2, 3}, {6, 1}}));
        // 输入: [[100, 100], [200, 100]]
        // 输出: [100, 100]
        RcbbPrinter.print(solution.fallingSquares(new int[][]{{100, 100}, {200, 100}}));
    }
}