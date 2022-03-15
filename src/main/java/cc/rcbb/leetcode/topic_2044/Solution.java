package cc.rcbb.leetcode.topic_2044;

/**
 * 2044. 统计按位或能得到最大值的子集数目
 * https://leetcode-cn.com/problems/count-number-of-maximum-bitwise-or-subsets/
 */
class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        int count = 0;
        int n = nums.length;

        int length = 1 << n;
        for (int i = 0; i < length; i++) {
            int orVal = 0;
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    orVal |= nums[j];
                }
            }
            if (orVal > maxOr) {
                maxOr = orVal;
                count = 1;
            } else if (orVal == maxOr) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countMaxOrSubsets(new int[]{3, 1}));
        System.out.println(solution.countMaxOrSubsets(new int[]{2, 2, 2}));
        System.out.println(solution.countMaxOrSubsets(new int[]{3, 2, 1, 5}));
    }

}