package cc.rcbb.leetcode.topic_1812;

/**
 * 1812. 判断国际象棋棋盘中一个格子的颜色
 * https://leetcode.cn/problems/determine-color-of-a-chessboard-square/
 * <p>
 * 模拟、数学
 */
class Solution {
    public boolean squareIsWhite(String coordinates) {
        return ((coordinates.charAt(0) - '0') + coordinates.charAt(1) - 'a') % 2 == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.squareIsWhite("a1"));
        System.out.println(solution.squareIsWhite("h3"));
        System.out.println(solution.squareIsWhite("c7"));
    }
}