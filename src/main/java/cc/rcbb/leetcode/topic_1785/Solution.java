package cc.rcbb.leetcode.topic_1785;

/**
 * 1785. 构成特定和需要添加的最少元素
 * https://leetcode.cn/problems/minimum-elements-to-add-to-form-a-given-sum/
 * <p>
 * 模拟
 */
class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int x : nums) {
            sum += x;
        }
        long diff = Math.abs(sum - goal);
        return (int) ((diff + limit - 1) / limit);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minElements(new int[]{1, -1, 1}, 3, -4));
        System.out.println(solution.minElements(new int[]{1, -10, 9, 1}, 100, 0));
    }

}