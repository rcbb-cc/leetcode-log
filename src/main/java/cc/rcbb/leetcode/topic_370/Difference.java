package cc.rcbb.leetcode.topic_370;

import cc.rcbb.leetcode.common.RcbbPrinter;

public class Difference {
    /**
     * 差分数组
     */
    public int[] diff;

    public Difference(int[] nums) {
        assert nums.length > 0;
        diff = new int[nums.length];
        // 构造差分数组
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    /**
     * 给闭区间 [i,j] 增加 val 或减少 val（val 是负数）
     * @param i
     * @param j
     * @param val
     */
    public void increment(int i, int j, int val) {
        diff[i] += val;
        if (j + 1 < diff.length) {
            diff[j + 1] -= val;
        }
        RcbbPrinter.print(diff);
    }

    public int[] result() {
        int[] res = new int[diff.length];
        // 根据差分数组构造结果数组
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }
}