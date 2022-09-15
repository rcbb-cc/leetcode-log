package cc.rcbb.leetcode.topic_672;

/**
 * 672. 灯泡开关 Ⅱ
 * https://leetcode.cn/problems/bulb-switcher-ii/
 */
class Solution {
    public int flipLights(int n, int presses) {
        if (presses == 0) {
            // 不按开关
            return 1;
        } else if (n == 1) {
            // 当 n == 1 时，开关1、3、4对其造成影响，也只有两种，开和关
            return 2;
        } else if (n == 2) {
            // 当 n == 2 时，按一次有3种，按2次及以上有4种
            return presses == 1 ? 3 : 4;
        } else {
            // 当 n >= 3 时，按一次有4种，按2次有7种，3次及以上有8种
            return presses == 1 ? 4 : presses == 2 ? 7 : 8;
        }
    }
}