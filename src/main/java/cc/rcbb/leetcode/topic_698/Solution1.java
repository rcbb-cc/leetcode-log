package cc.rcbb.leetcode.topic_698;

/**
 * 698. 划分为k个相等的子集
 * https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets/
 */
class Solution1 {
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
        int[] bucket = new int[k];
        // 理论中每个桶的数字的和
        int target = sum / k;
        // 穷举，看看 nums 是否能划分成 k 个和为 target 的子集
        return backtrack(nums, 0, bucket, target);
    }

    public boolean backtrack(int[] nums, int index, int[] bucket, int target) {
        if (index == nums.length) {
            // 检查每个桶中的和是否都是target
            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i] != target) {
                    return false;
                }
            }
            return true;
        }
        for (int i = 0; i < bucket.length; i++) {
            // 桶装满了
            if (bucket[i] + nums[index] > target) {
                continue;
            }
            // 将nums[index]装入bucket[i]桶
            bucket[i] += nums[index];
            // 穷举下一个数字的选择
            if (backtrack(nums, index + 1, bucket, target)) {
                return true;
            }
            // 撤销选择
            bucket[i] -= nums[index];
        }
        // 没有一个可行的结果
        return false;
    }
}