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

    public int pivotIndex2(int[] nums) {
        // 先计算总和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // 如果存在中间点：左边和+右边和+中间点=总和
        // 即：2*(左边和)+中间点=总和
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * total + nums[i] == sum) {
                return i;
            }
            total += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{1, 2, 3};
        //int[] nums = new int[]{2, 1, -1};
        //int[] nums = new int[]{1, 7, 3, 6, 5, 6};
        int r = solution.pivotIndex2(nums);
        System.out.println(r);

    }
}