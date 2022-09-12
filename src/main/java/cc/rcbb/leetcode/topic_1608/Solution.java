package cc.rcbb.leetcode.topic_1608;

import java.util.Arrays;

/**
 * 1608. 特殊数组的特征值
 * https://leetcode.cn/problems/special-array-with-x-elements-greater-than-or-equal-x/
 */
class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] >= i && (i == n || nums[i] < i)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.specialArray(new int[]{3, 5}));
        System.out.println(solution.specialArray(new int[]{0, 0}));
        System.out.println(solution.specialArray(new int[]{0, 4, 3, 0, 4}));
        System.out.println(solution.specialArray(new int[]{3, 6, 7, 7, 0}));
    }

}