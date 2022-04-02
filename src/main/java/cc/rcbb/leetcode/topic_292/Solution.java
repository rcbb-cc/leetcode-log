package cc.rcbb.leetcode.topic_292;

/**
 * 292. Nim 游戏
 * https://leetcode-cn.com/problems/nim-game/
 */
class Solution {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}