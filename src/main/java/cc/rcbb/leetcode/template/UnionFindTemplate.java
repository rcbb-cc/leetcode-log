package cc.rcbb.leetcode.template;

public class UnionFindTemplate {
}

/**
 * 或许你明明知道【并查集】的思想，但实现时却无从下手，接着往下看这几个[关键点]：
 * 1.并查集数组下标代表该节点本身，值代表其指向的父节点
 * 2.并查集的初始化：parent[i] = i ，父亲就是本身，各自为一个集合(也就是说每个节点都是根节点，下标等于值 是根节点的特征)
 * 3.find()方法，获得根节点：从此时的node下标开始，不断取parent[node]直到 下标等于值
 * 4.union()方法，合并两个连通分量：每个等式都对应一次连通操作；如何联通呢?让一个集合的根节点，成为另一个集合根节点的子节点(☆★☆)
 */
class UF {

    // 连通分量个数
    private int count;
    // 存储一棵树
    private int[] parent;
    // 记录树的重量
    private int[] size;

    public UF(int n) {
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            // 初始化重量为1
            size[i] = 1;
        }
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        // 小树接到大树下面，较平衡
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }

    /**
     * 判断是否连通
     */
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    /**
     * 返回某个节点x的根节点
     */
    public int find(int x) {
        while (parent[x] != x) {
            // 进行路径压缩
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    /**
     * 返回当前的连通分量个数
     */
    public int count() {
        return count;
    }

}
