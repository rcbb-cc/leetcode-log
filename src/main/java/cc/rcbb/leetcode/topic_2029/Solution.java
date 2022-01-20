package cc.rcbb.leetcode.topic_2029;

/**
 * 2029. 石子游戏 IX
 * https://leetcode-cn.com/problems/stone-game-ix/
 */
class Solution {
    public boolean stoneGameIX(int[] stones) {
        int cnt0 = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        for (int val : stones) {
            int type = val % 3;
            if (type == 0) {
                cnt0++;
            } else if (type == 1) {
                cnt1++;
            } else {
                cnt2++;
            }
        }
        if (cnt0 % 2 == 0) {
            return cnt1 >= 1 && cnt2 >= 1;
        }
        return cnt1 - cnt2 > 2 || cnt2 - cnt1 > 2;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.stoneGameIX(new int[]{2, 1}));
        System.out.println(solution.stoneGameIX(new int[]{2}));
        System.out.println(solution.stoneGameIX(new int[]{5, 1, 2, 4, 3}));

        // true
        System.out.println(solution.stoneGameIX(new int[]{1, 1, 7, 10, 8, 17, 10, 20, 2, 10}));
    }
}