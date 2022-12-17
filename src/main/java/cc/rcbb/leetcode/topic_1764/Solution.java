package cc.rcbb.leetcode.topic_1764;

/**
 * 1764. 通过连接另一个数组的子数组得到一个数组
 * https://leetcode.cn/problems/form-array-by-concatenating-subarrays-of-another-array/
 * <p>
 * 贪心、双指针
 */
class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        int i = 0;
        for (int k = 0; k < nums.length && i < groups.length; ) {
            if (check(groups[i], nums, k)) {
                k += groups[i].length;
                i++;
            } else {
                k++;
            }
        }
        return i == groups.length;
    }

    public boolean check(int[] g, int[] nums, int k) {
        if (k + g.length > nums.length) {
            return false;
        }
        for (int j = 0; j < g.length; j++) {
            if (g[j] != nums[k + j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canChoose(new int[][]{{1, -1, -1}, {3, -2, 0}}, new int[]{1, -1, 0, 1, -1, -1, 3, -2, 0}));
        System.out.println(solution.canChoose(new int[][]{{10, -2}, {1, 2, 3, 4}}, new int[]{1, 2, 3, 4, 10, -2}));
        System.out.println(solution.canChoose(new int[][]{{1, 2, 3}, {3, 4}}, new int[]{7, 7, 1, 2, 3, 4, 7, 7}));
    }
}