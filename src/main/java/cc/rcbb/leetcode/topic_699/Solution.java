package cc.rcbb.leetcode.topic_699;

import cc.rcbb.leetcode.common.RcbbPrinter;

import java.util.ArrayList;
import java.util.List;

/**
 * 699. 掉落的方块
 * https://leetcode.cn/problems/falling-squares/
 */
class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        int m = positions.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int left1 = positions[i][0], right1 = positions[i][0] + positions[i][1] - 1;
            int h = positions[i][1];
            for (int j = 0; j < i; j++) {
                int left2 = positions[j][0], right2 = positions[j][0] + positions[j][1] - 1;
                if (right1 >= left2 && right2 >= left1) {
                    h = Math.max(h, res.get(j) + positions[i][1]);
                }
            }
            res.add(h);
        }
        for (int i = 1; i < m; i++) {
            res.set(i, Math.max(res.get(i), res.get(i - 1)));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 输入: [[1, 2], [2, 3], [6, 1]]
        // 输出: [2, 5, 5]
        RcbbPrinter.print(solution.fallingSquares(new int[][]{{1, 2}, {2, 3}, {6, 1}}));
        // 输入: [[100, 100], [200, 100]]
        // 输出: [100, 100]
        RcbbPrinter.print(solution.fallingSquares(new int[][]{{100, 100}, {200, 100}}));


    }
}