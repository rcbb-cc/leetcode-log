package cc.rcbb.leetcode.topic_307;

/**
 * 307. 区域和检索 - 数组可修改
 * https://leetcode-cn.com/problems/range-sum-query-mutable/
 * <p>
 * 线段树
 * 线段树 segmentTree 是一个二叉树，每个结点保存数组 nums 在区间[s,e]的最小值、最大值或者总和等信息。
 * 线段树可以用书也可以用数组来实现。
 * 对于数组实现，假设根结点的下标为0，如果一个结点在数组的下标为node，
 * 那么它左子结点下标为 node*2+1，右子结点下标为 node*2+2。
 */
class NumArray2 {

    private int[] segmentTree;
    private int n;

    public NumArray2(int[] nums) {
        n = nums.length;
        segmentTree = new int[n * 4];
        build(0, 0, n - 1, nums);
    }

    public void update(int index, int val) {
        change(index, val, 0, 0, n - 1);
    }

    public int sumRange(int left, int right) {
        return range(left, right, 0, 0, n - 1);
    }

    private void build(int node, int s, int e, int[] nums) {
        if (s == e) {
            //s=e时，节点node是叶子节点，存储的是nums[s]
            segmentTree[node] = nums[s];
            return;
        }
        //s<e时
        int m = s + (e - s) / 2;
        //节点node的左子结点保存区间[s,[s+e/2]的总和
        build(node * 2 + 1, s, m, nums);
        //右子结点保存区间[[s+e/2]+1,e]的总和
        build(node * 2 + 2, m + 1, e, nums);
        segmentTree[node] = segmentTree[node * 2 + 1] + segmentTree[node * 2 + 2];
    }

    private void change(int index, int val, int node, int s, int e) {
        if (s == e) {
            segmentTree[node] = val;
            return;
        }
        int m = s + (e - s) / 2;
        if (index <= m) {
            change(index, val, node * 2 + 1, s, m);
        } else {
            change(index, val, node * 2 + 2, m + 1, e);
        }
        segmentTree[node] = segmentTree[node * 2 + 1] + segmentTree[node * 2 + 2];
    }

    private int range(int left, int right, int node, int s, int e) {
        if (left == s && right == e) {
            //如果结点node对应的区间与[left,node]限购听，直接返回该结点的值
            return segmentTree[node];
        }
        //左子结点对应的区间的右端点为m
        int m = s + (e - s) / 2;
        if (right <= m) {
            return range(left, right, node * 2 + 1, s, m);
        } else if (left > m) {
            return range(left, right, node * 2 + 2, m + 1, e);
        } else {
            return range(left, m, node * 2 + 1, s, m) + range(m + 1, right, node * 2 + 2, m + 1, e);
        }
    }

}