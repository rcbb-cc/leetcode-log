package cc.rcbb.leetcode.topic_698;

import java.util.Arrays;

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
        // 总数对k取余不为零
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        // 剪枝1
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        return backtrack(nums, 0, new int[k], k, target);
    }

    public boolean backtrack(int[] nums, int index, int[] bucket, int k, int target) {
        if (index == nums.length) {
            return true;
        }
        for (int i = 0; i < k; i++) {
            // 剪枝2
            if (i > 0 && bucket[i] == bucket[i - 1]) {
                continue;
            }
            if (bucket[i] + nums[index] > target) {
                continue;
            }
            bucket[i] += nums[index];
            if (backtrack(nums, index + 1, bucket, k, target)) {
                return true;
            }
            bucket[i] -= nums[index];
        }
        // 没有一个可行的结果
        return false;
    }
}