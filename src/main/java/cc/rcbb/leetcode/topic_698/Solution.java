package cc.rcbb.leetcode.topic_698;

/**
 * 698. 划分为k个相等的子集
 * https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets/
 */
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 当k数量大于数字个数时，不可能成功
        if (k > nums.length) {
            return false;
        }
        int sum = 0;
        for (int v : nums) {
            sum += v;
        }
        // 总和对k取余不为零，不可能成功
        if (sum % k != 0) {
            return false;
        }
        // 每个桶中的理论和
        int target = sum / k;
        // 为了标记该数是否有被使用
        boolean[] used = new boolean[nums.length];
        // 穷举
        return backtrack(k, 0, nums, 0, used, target);
    }

    boolean backtrack(int k, int bucket, int[] nums, int start, boolean[] used, int target) {
        // 当所有桶都用完了，而且nums一定也全用完了
        if (k == 0) {
            return true;
        }
        // 当前桶装满了
        if (bucket == target) {
            // 让下一个桶从 nums[0] 开始选数字
            return backtrack(k - 1, 0, nums, 0, used, target);
        }
        // 从 start 开始
        for (int i = start; i < nums.length; i++) {
            // 这个数字已经在其他桶中了
            if (used[i]) {
                continue;
            }
            // 做选择，将nums[i]装入桶中
            bucket += nums[i];
            used[i] = true;
            // 穷举下一个数字是否装入桶
            if (backtrack(k, bucket, nums, i + 1, used, target)) {
                return true;
            }
            // 撤销选择
            bucket -= nums[i];
            used[i] = false;
        }
        return false;
    }
}