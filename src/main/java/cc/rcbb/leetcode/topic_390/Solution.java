package cc.rcbb.leetcode.topic_390;

/**
 * 390. 消除游戏
 * https://leetcode-cn.com/problems/elimination-game/
 */
class Solution {
    public int lastRemaining(int n) {
        int head = 1;
        int step = 1;
        boolean left = true;
        while (n > 1) {
            if (left || n % 2 != 0) {
                head += step;
            }
            step <<= 1;
            n >>= 1;
            left = !left;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 输入：n = 9
        // 输出：6
        // 解释：
        // arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
        // arr = [2, 4, 6, 8]
        // arr = [2, 6]
        // arr = [6]
        System.out.println(solution.lastRemaining(9));
        System.out.println(solution.lastRemaining(1));

    }
}