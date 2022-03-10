package cc.rcbb.leetcode.topic_724;

/**
 * 724. 寻找数组的中心下标
 * https://leetcode-cn.com/problems/find-pivot-index/
 */
class Solution {

    public int pivotIndex(int[] nums) {
        // 先计算总和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            // 中心下标是左边、右边都包含的，所以在这里进行判断
            if (total == sum) {
                return i;
            }
            sum -= nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pivotIndex(new int[]{2, 1, -1}));
        System.out.println(solution.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }
}