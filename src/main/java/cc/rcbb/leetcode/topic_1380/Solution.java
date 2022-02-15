package cc.rcbb.leetcode.topic_1380;

import java.util.ArrayList;
import java.util.List;

/**
 * 1380. 矩阵中的幸运数
 * https://leetcode-cn.com/problems/lucky-numbers-in-a-matrix/
 */
class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            int t = matrix[i][0];
            int index = 0;
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] < t) {
                    t = matrix[i][j];
                    index = j;
                }
            }
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (matrix[j][index] > t) {
                    flag = false;
                }
            }
            if (flag) {
                res.add(t);
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
        //输出：[15]
        //解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
        System.out.println(solution.luckyNumbers(new int[][]{{3,7,8},{9,11,13},{15,16,17}}));
        //输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
        //输出：[12]
        System.out.println(solution.luckyNumbers(new int[][]{{1,10,4,2},{9,3,8,7},{15,16,17,12}}));
        //输入：matrix = [[7,8],[1,2]]
        //输出：[7]
        System.out.println(solution.luckyNumbers(new int[][]{{7,8},{1,2}}));
    }
}