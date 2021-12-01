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
            if (nums[i] <= nums[i - 1]) {
                start = i;
            }
            max = Math.max(max, i - start);
        }
        return max + 1;
    }

    public int findLengthOfLCIS1(int[] nums) {
        int index = 0;
        int curr = 0;
        int max = 0;
        // 开始的位置
        while (index < nums.length) {
            // 当前位置+1，需要小于
            if (curr + 1 < nums.length) {
                if (nums[curr] < nums[curr + 1]) {
                    // 后面比前面大，就往前走一步
                    curr++;
                } else {
                    // 后面不比前面大，计算当前走了多少步
                    max = Math.max(max, curr - index);
                    // 下一个开始位置为当前位置的下一步
                    index = curr + 1;
                    // 当前位置为开始位置
                    curr = index;
                }
            } else {
                // 代表走到头了，当前位置-开始位置
                max = Math.max(max, curr - index);
                break;
            }
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