package cc.rcbb.leetcode.topic_1260;

import java.util.ArrayList;
import java.util.List;

/**
 * 1260. 二维网格迁移
 * https://leetcode.cn/problems/shift-2d-grid/
 */
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(0);
            }
            ret.add(row);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = (i * n + j + k) % (m * n);
                ret.get(index / n).set(index % n, grid[i][j]);
            }
        }
        return ret;
    }
}