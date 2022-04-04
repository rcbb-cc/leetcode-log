package cc.rcbb.leetcode.topic_307;

/**
 * 307. 区域和检索 - 数组可修改
 * https://leetcode-cn.com/problems/range-sum-query-mutable/
 * <p>
 * 分块处理
 * 设数组大小为 n，我们将数组 nums 分为多个块，每个块大小为 size，
 * 最后一个块的大小为剩余的不超过 size 的元素数目，那么块的总数为 [n/size]
 *
 */
class NumArray1 {

    private int[] sum;
    private int size;
    private int[] nums;

    public NumArray1(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        //块大小
        size = (int) Math.sqrt(n);
        //n/size向上取整
        sum = new int[(n + size - 1) / size];
        for (int i = 0; i < n; i++) {
            sum[i / size] += nums[i];
        }
    }

    public void update(int index, int val) {
        sum[index / size] += val - nums[index];
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        int b1 = left / size;
        int i1 = left % size;
        int b2 = right / size;
        int i2 = right % size;
        if (b1 == b2) {
            //left、right在同一区间
            int sum = 0;
            for (int i = i1; i <= i2; i++) {
                sum += nums[b1 * size + i];
            }
            return sum;
        }
        //前半部分[left,left+size)
        int sum1 = 0;
        for (int i = i1; i < size; i++) {
            sum1 += nums[b1 * size + i];
        }
        //中间部分[0,size)
        int sum2 = 0;
        for (int i = b1 + 1; i < b2; i++) {
            sum2 += sum[i];
        }
        //后半部分[0,right]
        int sum3 = 0;
        for (int i = 0; i <= i2; i++) {
            sum3 += nums[b2 * size + i];
        }
        return sum1 + sum2 + sum3;
    }
}
