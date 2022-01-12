package cc.rcbb.leetcode.topic_334;


/**
 * 334. 递增的三元子序列
 * https://leetcode-cn.com/problems/increasing-triplet-subsequence/
 */
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int first = nums[0];
        int second = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int third = nums[i];
            if (third > second) {
                return true;
            }
            if (first < third) {
                second = third;
            } else {
                first = third;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.increasingTriplet(new int[]{6, 3, 5, 10, 11, 2, 9, 14, 13, 7, 4, 8, 12}));
        //System.out.println(solution.increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        //System.out.println(solution.increasingTriplet(new int[]{5, 4, 3, 2, 1}));
        //System.out.println(solution.increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}));
        //[20,100,10,12,5,13] true
        //System.out.println(solution.increasingTriplet(new int[]{20, 100, 10, 12, 5, 13}));
    }
}