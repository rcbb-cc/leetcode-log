package cc.rcbb.leetcode.topic_747;

/**
 * 747. 至少是其他数字两倍的最大数
 * https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others/
 */
class Solution {
    /**
     * 思路：找出最大和次最大，如果次最大*2都小于最大，那肯定所有数都小于
     */
    public int dominantIndex(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        int secondMax = -1;
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[max]) {
                secondMax = max;
                max = i;
            } else if (secondMax == -1 || nums[i] > nums[secondMax]) {
                secondMax = i;
            }
        }
        if (nums[max] >= nums[secondMax] * 2) {
            return max;
        }
        return -1;
    }

    /**
     * 两次循环
     */
    public int dominantIndex1(int[] nums) {
        int max = -1;
        int maxIndex = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != max &&
                    nums[i] * 2 > max) {
                return -1;
            }
        }
        return maxIndex;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.dominantIndex(new int[]{3, 6, 1, 0}));
        System.out.println(solution.dominantIndex(new int[]{1, 2, 3, 4}));
        System.out.println(solution.dominantIndex(new int[]{1}));
    }

}