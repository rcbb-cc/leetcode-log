package cc.rcbb.leetcode.topic_2044;

/**
 * 2044. 统计按位或能得到最大值的子集数目
 * https://leetcode-cn.com/problems/count-number-of-maximum-bitwise-or-subsets/
 */
class Solution1 {
    int count = 0;
    int maxOr = 0;

    public int countMaxOrSubsets(int[] nums) {
        dfs(nums, 0, 0);
        return count;
    }

    private void dfs(int[] nums, int i, int or) {
        if (i == nums.length) {
            if (or > maxOr) {
                maxOr = or;
                count = 1;
            } else if (or == maxOr) {
                count++;
            }
            return;
        }
        dfs(nums, i + 1, or | nums[i]);
        dfs(nums, i + 1, or);
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.countMaxOrSubsets(new int[]{3, 1}));
        System.out.println(solution.countMaxOrSubsets(new int[]{2, 2, 2}));
        System.out.println(solution.countMaxOrSubsets(new int[]{3, 2, 1, 5}));
    }

}