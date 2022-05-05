package cc.rcbb.leetcode.topic_713;

/**
 * 713. 乘积小于 K 的子数组
 * https://leetcode-cn.com/problems/subarray-product-less-than-k/
 */
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0, sum = 1;
        for (int r = 0, l = 0; r < nums.length; r++) {
            sum *= nums[r];
            while (sum >= k && l <= r) {
                sum /= nums[l++];
            }
            count += r - l + 1;
        }
        return count;
    }

    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < n; j++) {
                sum = sum * nums[j];
                if (sum < k) {
                    count++;
                } else {
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] < k) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        System.out.println(solution.numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0));
    }

}