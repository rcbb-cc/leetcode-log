package cc.rcbb.leetcode.topic_307;

/**
 * 307. 区域和检索 - 数组可修改
 * https://leetcode-cn.com/problems/range-sum-query-mutable/
 * <p>
 * 树状数组
 * 树状数组是一种可以动态维护序列前缀和的数据结构。
 * 它的功能：
 * 单点修改 add(index,val)：把序列第 index 个数增加 val；
 * 区间查询 prefixSum(index)：查询前 index 元素的前缀和
 */
class NumArray {

    private int[] tree;
    private int[] nums;

    public NumArray(int[] nums) {
        this.tree = new int[nums.length + 1];
        this.nums = nums;
        for (int i = 0; i < nums.length; i++) {
            add(i + 1, nums[i]);
        }
    }

    public void update(int index, int val) {
        add(index + 1, val - nums[index]);
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return prefixSum(right + 1) - prefixSum(left);
    }


    private int lowBit(int x) {
        return x & -x;
    }

    private void add(int index, int val) {
        while (index < tree.length) {
            tree[index] += val;
            index += lowBit(index);
        }
    }

    private int prefixSum(int index) {
        int sum = 0;
        while (index > 0) {
            sum += tree[index];
            index -= lowBit(index);
        }
        return sum;
    }
}