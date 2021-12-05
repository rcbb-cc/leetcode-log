package cc.rcbb.leetcode.topic_877;

/**
 * 877. 石子游戏
 * https://leetcode-cn.com/problems/stone-game/
 */
class Solution {
    public boolean stoneGame(int[] piles) {
        /**
         * 由于石子堆数为偶数：
         * 因此先手的最开始局面必然是 [奇数, 偶数][奇数,偶数]，
         * 即必然是「奇偶性不同的局面」；
         * 当先手决策完之后，
         * 交到给后手的要么是 [奇数,奇数][奇数,奇数] 或者 [偶数,偶数][偶数,偶数]，即必然是「奇偶性相同的局面」；
         * 后手决策完后，又恢复「奇偶性不同的局面」交回到先手 ...
         *
         * 石头总数为奇数：总会存在胜者
         *
         * 所以先手必胜。
         */
        return true;
    }
}