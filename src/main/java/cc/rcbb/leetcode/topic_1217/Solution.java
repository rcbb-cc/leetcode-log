package cc.rcbb.leetcode.topic_1217;

/**
 * 1217. 玩筹码
 * https://leetcode.cn/problems/minimum-cost-to-move-chips-to-the-same-position/
 */
class Solution {
    public int minCostToMoveChips(int[] position) {
        int odd = 0, even = 0;
        for (int i = 0; i < position.length; i++) {
            if (position[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return Math.min(even, odd);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minCostToMoveChips(new int[]{1, 2, 3}));
        System.out.println(solution.minCostToMoveChips(new int[]{2, 2, 2, 3, 3}));
        System.out.println(solution.minCostToMoveChips(new int[]{1, 1000000000}));
    }
}