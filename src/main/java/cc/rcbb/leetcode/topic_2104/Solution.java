package cc.rcbb.leetcode.topic_2104;

/**
 * 2104. 子数组范围和
 * https://leetcode-cn.com/problems/sum-of-subarray-ranges/
 */
class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long sum = 0;
        return sum;
    }

    public long subArrayRanges1(int[] nums) {
        int n = nums.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int min = nums[i];
            int max = nums[i];
            for (int j = i + 1; j < n; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                sum += max - min;
                System.out.println(min + " " + max);
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        /*输入：nums = [1,2,3]
        输出：4
        解释：nums 的 6 个子数组如下所示：
                [1]，范围 = 最大 - 最小 = 1 - 1 = 0
                [2]，范围 = 2 - 2 = 0
                [3]，范围 = 3 - 3 = 0
                [1,2]，范围 = 2 - 1 = 1
                [2,3]，范围 = 3 - 2 = 1
                [1,2,3]，范围 = 3 - 1 = 2
        所有范围的和是 0 + 0 + 0 + 1 + 1 + 2 = 4*/
        System.out.println(solution.subArrayRanges(new int[]{1, 2, 3}));
        /*输入：nums = [1,3,3]
        输出：4
        解释：nums 的 6 个子数组如下所示：
                [1]，范围 = 最大 - 最小 = 1 - 1 = 0
                [3]，范围 = 3 - 3 = 0
                [3]，范围 = 3 - 3 = 0
                [1,3]，范围 = 3 - 1 = 2
                [3,3]，范围 = 3 - 3 = 0
                [1,3,3]，范围 = 3 - 1 = 2
        所有范围的和是 0 + 0 + 0 + 2 + 0 + 2 = 4*/
        System.out.println(solution.subArrayRanges(new int[]{1, 3, 3}));
        //输入：nums = [4,-2,-3,4,1]
        //输出：59
        //解释：nums 中所有子数组范围的和是 59
        System.out.println(solution.subArrayRanges(new int[]{4, -2, -3, 4, 1}));
    }
}