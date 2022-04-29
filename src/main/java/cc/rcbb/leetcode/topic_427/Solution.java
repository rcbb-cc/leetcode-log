package cc.rcbb.leetcode.topic_427;

/**
 * 427. 建立四叉树
 * https://leetcode-cn.com/problems/construct-quad-tree/
 */
class Solution {
    public Node construct(int[][] grid) {
        return dfs(grid, 0, 0, grid.length - 1, grid[0].length - 1);
    }

    private Node dfs(int[][] grid, int a, int b, int c, int d) {
        boolean ok = true;
        int t = grid[a][b];
        for (int i = a; i <= c && ok; i++) {
            for (int j = b; j <= d && ok; j++) {
                if (grid[i][j] != t) {
                    ok = false;
                }
            }
        }
        if (ok) {
            // 全是0或1，直接创建根节点
            return new Node(t == 1, true);
        }
        // 不是根节点
        Node root = new Node(t == 1, false);
        // 横坐标长度
        int dx = c - a + 1;
        // 纵坐标长度
        int dy = d - b + 1;
        // 分成四块
        root.topLeft = dfs(grid, a, b, a + dx / 2 - 1, b + dy / 2 - 1);
        root.topRight = dfs(grid, a, b + dy / 2, a + dx / 2 - 1, d);
        root.bottomLeft = dfs(grid, a + dx / 2, b, c, b + dy / 2 - 1);
        root.bottomRight = dfs(grid, a + dx / 2, b + dy / 2, c, d);
        return root;
    }

}


class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
