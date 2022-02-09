package cc.rcbb.leetcode.topic_2006;

/**
 * 2006. 差的绝对值为 K 的数对数目
 * https://leetcode-cn.com/problems/count-number-of-pairs-with-absolute-difference-k/
 */
class Solution {
    public int countKDifference(int[] nums, int k) {
        int[] arr = new int[101];
        for (int num : nums) {
            arr[num]++;
        }
        int count = 0;
        for (int i = 0; i + k < 101; i++) {
            count += arr[i] * arr[i + k];
        }
        return count;
    }

    public int countKDifference1(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countKDifference(new int[]{1, 2, 2, 1}, 1));
        System.out.println(solution.countKDifference(new int[]{1, 3}, 3));
        System.out.println(solution.countKDifference(new int[]{3, 2, 1, 5, 4}, 2));

    }


}