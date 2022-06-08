package cc.rcbb.leetcode.topic_1037;

/**
 * 1037. 有效的回旋镖
 * https://leetcode.cn/problems/valid-boomerang/
 */
class Solution {
    public boolean isBoomerang(int[][] p) {
        int[] ab = {p[1][0] - p[0][0], p[1][1] - p[0][1]};
        int[] bc = {p[2][0] - p[1][0], p[2][1] - p[1][1]};
        int r = ab[0] * bc[1] - bc[0] * ab[1];
        return r != 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isBoomerang(new int[][]{{1, 1}, {2, 3}, {3, 2}}));
        System.out.println(solution.isBoomerang(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
    }
}