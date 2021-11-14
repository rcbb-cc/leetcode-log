package cc.rcbb.leetcode.topic_990;

import java.util.ArrayList;
import java.util.List;

/**
 * 990. 等式方程的可满足性
 * https://leetcode-cn.com/problems/satisfiability-of-equality-equations/
 */
class Solution {
    /*
     * 我们可以根据其相等性将26个字母分为多个集合：我们只关心连通性不关心距离，典型的【并查集】
     *
     * 【并查集】需要用到树结构，这个树结构通常是通过数组或哈希表实现的
     * 就此题而言：
     * 		先扫描所有的等式，将等式两边的顶点进行合并(实际上就将两个集合联通了起来)
     * 		然后扫描所有不等式，如果等式两边在同一个连通分量内，则出现矛盾，返回false；如果扫描结束没有矛盾，则返回true
     *
     * 或许你明明知道【并查集】的思想，但实现时却无从下手，接着往下看这几个[关键点]：
     * 		1.并查集数组下标代表该节点本身，值代表其指向的父节点
     * 		2.并查集的初始化：parent[i] = i ，父亲就是本身，各自为一个集合(也就是说每个节点都是根节点，下标等于值 是根节点的特征)
     * 		3.find()方法，获得根节点：从此时的node下标开始，不断取parent[node]直到 下标等于值
     * 		4.union()方法，合并两个连通分量：每个等式都对应一次连通操作；如何联通呢?让一个集合的根节点，成为另一个集合根节点的子节点(☆★☆)
     *
     * 并查集的优化：
     * 		如果一个路径较长的话，会影响性能 —— 长路径毫无意义，一个集合(连通分量)的树形状没有实际意义，并查集的性质只有【连通性】而无关路径
     * 		在不断的扫描中，并查集一直在动态变化；其实在这个过程中，树的形状也可以同时动态变化
     * 		【并查集】的优化有两种：
     * 				1.路径压缩(隔代压缩和完全压缩)：动态减小树的高度，将长路径转化掉
     * 				2.按秩合并：根据树的高度进行合并(union)，即将高度低的树接到高度高的树上，防止高度的增长
     * 本题中：采用路径压缩(见代码)
     */
    public boolean equationsPossible(String[] equations) {
        UF uf = new UF(26);
        List<int[]> list = new ArrayList<>();
        for (String s : equations) {
            char x = s.charAt(0);
            char y = s.charAt(3);
            if (s.charAt(1) == '=') {
                uf.union(x - 'a', y - 'a');
            } else {
                list.add(new int[]{x - 'a', y - 'a'});
            }
        }
        for (int[] arr : list) {
            if (uf.find(arr[0]) == uf.find(arr[1])) {
                return false;
            }
        }
        return true;
    }

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
}


