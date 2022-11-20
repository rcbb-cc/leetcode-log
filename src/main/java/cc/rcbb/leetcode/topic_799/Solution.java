package cc.rcbb.leetcode.topic_799;


/**
 * 799. 香槟塔
 * https://leetcode-cn.com/problems/champagne-tower/
 * <p>
 * 模拟
 */
class Solution {

    /**
     * @param poured      倾倒香槟总杯数
     * @param query_row   杯子的行数
     * @param query_glass 杯子的位置
     * @return
     */
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] capacity = new double[101][101];
        capacity[0][0] = poured;
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                double d = (capacity[i][j] - 1.0) / 2;
                if (d > 0) {
                    capacity[i + 1][j] += d;
                    capacity[i + 1][j + 1] += d;
                }
            }
        }
        return Math.min(1, capacity[query_row][query_glass]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.champagneTower(1, 1, 1));
        System.out.println(solution.champagneTower(2, 1, 1));
        System.out.println(solution.champagneTower(100000009, 33, 17));
        System.out.println(solution.champagneTower(1000000000, 99, 99));
    }

}