package cc.rcbb.leetcode.topic_775;

/**
 * 775. 全局倒置与局部倒置
 * https://leetcode.cn/problems/global-and-local-inversions/
 * <p>
 * 模拟、维护后缀最小值
 */
class Solution {
    /**
     * 一个局部倒置一定是一个全局倒置
     * 因此要判断数组中局部倒置的数量是否与全局倒置的数量相等，只需要检查有没有非局部倒置就可以了。
     * <p>
     * 非局部倒置指的是 nums[i] > nums[j]，其中 i < j - 1。
     *
     * @param nums
     * @return
     */
    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length;
        int minSuff = nums[n - 1];
        for (int i = n - 3; i >= 0; i--) {
            if (nums[i] > minSuff) {
                return false;
            }
            minSuff = Math.min(minSuff, nums[i + 1]);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isIdealPermutation(new int[]{1, 0, 2}));
        System.out.println(solution.isIdealPermutation(new int[]{1, 2, 0}));
    }
}