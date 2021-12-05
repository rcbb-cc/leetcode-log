package cc.rcbb.leetcode.topic_877;
/**
 * 877. 石子游戏
 * https://leetcode-cn.com/problems/stone-game/
 *
 * 会超时
 */
class Solution1 {
    public boolean stoneGame(int[] piles) {
        int sum = 0;
        for (int i = 0; i < piles.length; i++) {
            sum += piles[i];
        }
        int p1 = f(piles, 0, piles.length-1);
        return p1 > sum - p1;
    }

    public int f(int[] piles, int l, int r) {
        if (l == r) {
            return piles[l];
        }
        int sLeft = 0;
        int sRight = 0;
        if (r - l == 1) {
            sLeft = piles[l];
            sRight = piles[r];
        }
        if (r - l >= 2) {
            sLeft = piles[l] + Math.min(f(piles, l + 2, r), f(piles, l + 1, r - 1));
            sRight = piles[r] + Math.min(f(piles, l + 1, r - 1), f(piles, l, r - 2));
        }
        return Math.max(sLeft, sRight);
    }
}