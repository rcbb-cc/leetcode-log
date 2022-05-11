package cc.rcbb.leetcode.topic_390;

/**
 * 390. 消除游戏
 * https://leetcode-cn.com/problems/elimination-game/
 */
class Solution {
    public int lastRemaining(int n) {
        if (n == 1) {
            return 1;
        }
        return 2 * (n / 2 + 1 - lastRemaining(n / 2));
    }

    public int lastRemaining1(int n) {
        int head = 1;
        int step = 1;
        boolean left = true;
        while (n > 1) {
            // 从左边开始移出 或 （从右边开始移出，总数为奇数）
            if (left || n % 2 != 0) {
                head += step;
            }
            // 步长 * 2
            step <<= 1;
            // 总数 / 2
            n >>= 1;
            // 取反移除方向
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
        System.out.println(solution.lastRemaining1(9));
        System.out.println(solution.lastRemaining(9));
        System.out.println(solution.lastRemaining(1));
    }
}