package cc.rcbb.leetcode.topic_812;

/**
 * 812. 最大三角形面积
 * https://leetcode.cn/problems/largest-triangle-area/
 */
class Solution {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double max = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    max = Math.max(max, triangleArea(points[i][0], points[i][1],
                            points[j][0], points[j][1],
                            points[k][0], points[k][1]));
                }
            }
        }
        return max;
    }

    private double triangleArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        return 0.5 * Math.abs(x1 * y2 + x2 * y3 + x3 * y1 - x1 * y3 - x2 * y1 - x3 * y2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestTriangleArea(new int[][]{{1, 0}, {0, 1}, {0, 0}}));
        System.out.println(solution.largestTriangleArea(new int[][]{{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}}));
    }
}