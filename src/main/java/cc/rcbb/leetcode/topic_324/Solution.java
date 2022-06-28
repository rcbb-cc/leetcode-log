package cc.rcbb.leetcode.topic_324;

import cc.rcbb.leetcode.common.RcbbPrinter;

import java.util.Arrays;

/**
 * 324. 摆动排序 II
 * https://leetcode.cn/problems/wiggle-sort-ii/
 */
class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] clone = nums.clone();
        Arrays.sort(clone);
        int left = (n - 1) / 2, right = n - 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = clone[left--];
            } else {
                nums[i] = clone[right--];
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1：
        // 输入：nums = [1,5,1,1,6,4]
        // 输出：[1,6,1,5,1,4]
        // 解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
        int[] nums = new int[]{1, 5, 1, 1, 6, 4};
        solution.wiggleSort(nums);
        RcbbPrinter.print(nums);
        // 示例 2：
        // 输入：nums = [1,3,2,2,3,1]
        // 输出：[2,3,1,3,1,2]
        nums = new int[]{1, 3, 2, 2, 3, 1};
        solution.wiggleSort(nums);
        RcbbPrinter.print(nums);
    }
}