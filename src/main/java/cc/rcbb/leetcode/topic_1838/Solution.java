package cc.rcbb.leetcode.topic_1838;

import java.util.Arrays;

/**
 * 1838. 最高频元素的频数
 * https://leetcode-cn.com/problems/frequency-of-the-most-frequent-element/
 */
class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int right = 1;
        int count = 0;
        int max = 1;
        while (right < n) {
            count += (nums[right] - nums[right - 1]) * (right - left);
            while (count > k) {
                count -= nums[right] - nums[left];
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        //输入：nums = [1,2,4], k = 5
        //输出：3
        //解释：对第一个元素执行 3 次递增操作，对第二个元素执 2 次递增操作，此时 nums = [4,4,4] 。
        //4 是数组中最高频元素，频数是 3 。
        System.out.println(solution.maxFrequency(new int[]{1, 2, 4}, 5));
        //输入：nums = [1,4,8,13], k = 5
        //输出：2
        System.out.println(solution.maxFrequency(new int[]{1, 4, 8, 13}, 5));
        //输入：nums = [3,9,6], k = 2
        //输出：1
        System.out.println(solution.maxFrequency(new int[]{3, 9, 6}, 2));
    }
}