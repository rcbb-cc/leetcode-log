package cc.rcbb.leetcode.topic_303;

/**
 * 303. 区域和检索 - 数组不可变
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 */
class NumArray {

    private int arr[] = null;

    public NumArray(int[] nums) {
        arr = new int[nums.length + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = nums[i - 1] + arr[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return arr[right + 1] - arr[left];
    }

    public void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        numArray.print();
        int s1 = numArray.sumRange(0, 2);
        System.out.println("s1 = " + s1);
        int s2 = numArray.sumRange(2, 5);
        System.out.println("s2 = " + s2);
        int s3 = numArray.sumRange(0, 5);
        System.out.println("s3 = " + s3);
    }
}