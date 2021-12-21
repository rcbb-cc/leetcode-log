package cc.rcbb.leetcode.topic_1887;

import java.util.Arrays;

/**
 * 1887. 使数组元素相等的减少操作次数
 * https://leetcode-cn.com/problems/reduction-operations-to-make-the-array-elements-equal/
 */
class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        // 总操作数
        int res = 0;
        // 每个元素操作次数
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] != nums[i]) {
                cnt++;
            }
            res += cnt;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reductionOperations(new int[]{5, 1, 3}));
        System.out.println(solution.reductionOperations(new int[]{1, 1, 1}));
        System.out.println(solution.reductionOperations(new int[]{1, 1, 2, 2, 3}));
    }
}