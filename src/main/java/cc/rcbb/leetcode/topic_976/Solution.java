package cc.rcbb.leetcode.topic_976;

import java.util.Arrays;

/**
 * 976. 三角形的最大周长
 * https://leetcode-cn.com/problems/largest-perimeter-triangle/
 *
 * 为什么排序遍历相邻元素可行，有没有可能最优解为非相邻元素？
 * 证明：反证，假设a，b，c为最优解，且存在a1,b1，满足 a < a1 < b < b1 < c即存在非相邻元素。
 * 1.由于a+b > c，a<a1，有a1+b>c，（a1,b,c）优于(a,b,c)，与(a,b,c)为最优解矛盾，故不存在a1。
 * 2.同理b1也不存在。
 * 因此最优解已定位排序后相邻元素。
 */
class Solution {
    public int largestPerimeter(int[] nums) {
        // 排序
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            // 两边之和大于第三边
            if (nums[i - 1] + nums[i - 2] > nums[i]) {
                return nums[i - 1] + nums[i - 2] + nums[i];
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2, 2, 4, 18, 8};
        int i = solution.largestPerimeter(nums);
        System.out.println(i);
    }
}