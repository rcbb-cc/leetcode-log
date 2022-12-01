package cc.rcbb.leetcode.topic_1779;

/**
 * 1779. 找到最近的有相同 X 或 Y 坐标的点
 * https://leetcode.cn/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/
 * <p>
 * 模拟
 */
class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int m = points.length;
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < m; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            if (x == x1 || y == y1) {
                int temp = Math.abs(x - x1) + Math.abs(y - y1);
                if (temp < min) {
                    min = temp;
                    index = i;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nearestValidPoint(3, 4, new int[][]{{1, 2}, {3, 1}, {2, 4}, {2, 3}}));
        System.out.println(solution.nearestValidPoint(3, 4, new int[][]{{3, 4}}));
        System.out.println(solution.nearestValidPoint(3, 4, new int[][]{{2, 3}}));
    }
}