package cc.rcbb.leetcode.topic_1822;

/**
 * 1822. 数组元素积的符号
 * https://leetcode.cn/problems/sign-of-the-product-of-an-array/
 * <p>
 * 模拟
 */
class Solution {
    public int arraySign(int[] nums) {
        boolean negative = false;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                return 0;
            } else if (nums[i] < 0) {
                negative = !negative;
            }
        }
        return negative ? -1 : 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.arraySign(new int[]{-1, -2, -3, -4, 3, 2, 1}));
        System.out.println(solution.arraySign(new int[]{1, 5, 0, 2, -3}));
        System.out.println(solution.arraySign(new int[]{-1, 1, -1, 1, -1}));
    }
}