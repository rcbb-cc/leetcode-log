package cc.rcbb.leetcode.topic_674;

/**
 * 674. 最长连续递增序列
 * https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 */
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int start = 0;
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            // 如果第i步不再大于第i-1步，则在第i步重新开始
            if (nums[i] <= nums[i - 1]) {
                start = i;
            }
            // 保存最大的步数
            max = Math.max(max, i - start);
        }
        return max + 1;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        //int[] nums = new int[]{1, 1, 1};
        //int[] nums = new int[]{1, 3, 5, 4, 7};
        int[] nums = new int[]{1, 3, 5, 6, 7};
        int r = solution.findLengthOfLCIS(nums);
        System.out.println(r);

    }
}