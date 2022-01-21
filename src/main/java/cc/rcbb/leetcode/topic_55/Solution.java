package cc.rcbb.leetcode.topic_55;

/**
 * 55. 跳跃游戏
 * https://leetcode-cn.com/problems/jump-game/
 */
class Solution {

    /**
     * 每一步都计算从当前位置最远能跳到哪里
     * 然后和一个全局最优的最远位置做对比
     * 通过每一步的最优解，更新全局最优解，这就是贪心。
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int step = 0;
        for (int i = 0; i < n - 1; i++) {
            step = Math.max(step, i + nums[i]);
            if (step <= i) {
                return false;
            }
        }
        return step >= n - 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入：nums = [2,3,1,1,4]
        //输出：true
        //解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
        System.out.println(solution.canJump(new int[]{2, 3, 1, 1, 4}));
        //输入：nums = [3,2,1,0,4]
        //输出：false
        //解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
        System.out.println(solution.canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(solution.canJump(new int[]{0}));
    }

}