package cc.rcbb.leetcode.topic_1464;

/**
 * 1464. 数组中两元素的最大乘积
 * https://leetcode.cn/problems/maximum-product-of-two-elements-in-an-array/
 */
class Solution {
    public int maxProduct(int[] nums) {
        int first = 0;
        int second = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > first) {
                second = first;
                first = nums[i];
            } else if (nums[i] > second) {
                second = nums[i];
            }
        }
        return (first - 1) * (second - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProduct(new int[]{1, 2}));
        System.out.println(solution.maxProduct(new int[]{2, 3}));
        System.out.println(solution.maxProduct(new int[]{1, 5, 4, 5}));
    }

}