package cc.rcbb.leetcode.topic_303;

/**
 * 303. 区域和检索 - 数组不可变
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 */
public class NumArray1 {

    private int nums[] = null;

    public NumArray1(int[] nums) {
        this.nums = nums;
    }

    /**
     * 循环计算和
     * 时间复杂度：O(n)
     */
    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray1 numArray = new NumArray1(nums);
        int s1 = numArray.sumRange(0, 2);
        System.out.println("s1 = " + s1);
        int s2 = numArray.sumRange(2, 5);
        System.out.println("s2 = " + s2);
        int s3 = numArray.sumRange(0, 5);
        System.out.println("s3 = " + s3);
    }
}