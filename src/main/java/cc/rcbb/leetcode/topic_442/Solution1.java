package cc.rcbb.leetcode.topic_442;

import cc.rcbb.leetcode.common.RcbbPrinter;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. 数组中重复的数据
 * https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/
 */
class Solution1 {
    /**
     * 使用正负号作为标记
     */
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = Math.abs(nums[i]);
            if (nums[x - 1] > 0) {
                nums[x - 1] = -nums[x - 1];
            } else {
                res.add(x);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        RcbbPrinter.print(solution.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        RcbbPrinter.print(solution.findDuplicates(new int[]{1, 1, 2}));
        RcbbPrinter.print(solution.findDuplicates(new int[]{1}));
    }
}