package cc.rcbb.leetcode.topic_442;

import cc.rcbb.leetcode.common.RcbbPrinter;

import java.util.ArrayList;
import java.util.List;
/**
 * 442. 数组中重复的数据
 * https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/
 */
class Solution {
    /**
     * 将元素交换到对应的位置
     * 因为 n 的个数在 [1,n]，如果有重复数字出现，就代表[1,n]中有数字未出现过。
     * 因此，尝试将每个数放在对应的位置。
     * <p>
     * 如果 i 恰好出现了一次，则 i 应该在 i-1 的位置上。
     * 如果 i 出现了两次，其中一个放在 i-1 的位置上，另一个 i 放在任意不冲突的位置上。
     *
     * 放置的方法：将数组进行一次遍历，遍历位置 i 时，我们知道 nums[i] 应该放在 nums[i]-1 的位置上。
     * 因此我们交换 num[i] 和 nums[nums[i]-1]即可，直到待交换的两个元素相等为止。
     */
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 因此我们交换 num[i] 和 nums[nums[i]-1]即可，直到待交换的两个元素相等为止。
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] - 1 != i) {
                res.add(nums[i]);
            }
        }
        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        RcbbPrinter.print(solution.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        RcbbPrinter.print(solution.findDuplicates(new int[]{1, 1, 2}));
        RcbbPrinter.print(solution.findDuplicates(new int[]{1}));
    }
}