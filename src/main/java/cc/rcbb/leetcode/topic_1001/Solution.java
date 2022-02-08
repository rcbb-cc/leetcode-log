package cc.rcbb.leetcode.topic_1001;

import cc.rcbb.leetcode.common.RcbbPrinter;

import java.util.*;

/**
 * 1001. 网格照明
 * https://leetcode-cn.com/problems/grid-illumination/
 */
class Solution {
    int[][] dirs = new int[][]{{0, 0}, {0, -1}, {0, 1}, {-1, 0}, {-1, -1}, {-1, 1}, {1, 0}, {1, -1}, {1, 1}};

    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        long N = n;
        Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();
        Map<Integer, Integer> diagonal = new HashMap<>();
        Map<Integer, Integer> antDiagonal = new HashMap<>();
        Set<Long> points = new HashSet<>();
        for (int[] lamp : lamps) {
            int x = lamp[0];
            int y = lamp[1];
            int left = x + y;
            int right = x - y;
            if (points.contains(x * N + y)) {
                continue;
            }
            increment(row, x);
            increment(col, y);
            increment(diagonal, left);
            increment(antDiagonal, right);
            points.add(x * N + y);
        }
        int m = queries.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int[] q = queries[i];
            int x = q[0];
            int y = q[1];
            int left = x + y;
            int right = x - y;
            if (row.containsKey(x) || col.containsKey(y) ||
                    diagonal.containsKey(left) || antDiagonal.containsKey(right)) {
                res[i] = 1;
            }
            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];
                int nleft = nx + ny;
                int nright = nx - ny;
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                if (points.contains(nx * N + ny)) {
                    points.remove(nx * N + ny);
                    decrement(row, nx);
                    decrement(col, ny);
                    decrement(diagonal, nleft);
                    decrement(antDiagonal, nright);
                }
            }
        }
        return res;
    }

    void increment(Map<Integer, Integer> map, int key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    void decrement(Map<Integer, Integer> map, int key) {
        if (map.get(key) == 1) {
            map.remove(key);
        } else {
            map.put(key, map.get(key) - 1);
        }
    }

    /**
     * 超时
     */
    public int[] gridIllumination1(int n, int[][] lamps, int[][] queries) {
        Map<String, List<String>> lampMap = new HashMap<>();
        Map<String, Integer> lampCountMap = new HashMap<>();
        Map<String, Integer> lightMap = new HashMap<>();
        for (int[] l : lamps) {
            int x = l[0];
            int y = l[1];
            String key = x + ":" + y;
            List<String> values = new ArrayList<>();
            lightMap.put(key, lightMap.getOrDefault(key, 0) + 1);
            values.add(key);
            for (int i = x - 1; i >= 0; i--) {
                //grid[i][y] = 1;
                String tk = i + ":" + y;
                values.add(tk);
                lightMap.put(tk, lightMap.getOrDefault(tk, 0) + 1);
            }
            for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; ) {
                //grid[i][j] = 1;
                String tk = i + ":" + j;
                values.add(tk);
                lightMap.put(tk, lightMap.getOrDefault(tk, 0) + 1);
                i--;
                j--;
            }
            for (int i = y - 1; i >= 0; i--) {
                //grid[x][i] = 1;
                String tk = x + ":" + i;
                values.add(tk);
                lightMap.put(tk, lightMap.getOrDefault(tk, 0) + 1);
            }
            for (int i = x + 1, j = y - 1; i < n && j >= 0; ) {
                //grid[i][j] = 1;
                String tk = i + ":" + j;
                values.add(tk);
                lightMap.put(tk, lightMap.getOrDefault(tk, 0) + 1);
                i++;
                j--;
            }
            for (int i = x + 1; i < n; i++) {
                //grid[i][y] = 1;
                String tk = i + ":" + y;
                values.add(tk);
                lightMap.put(tk, lightMap.getOrDefault(tk, 0) + 1);
            }
            for (int i = x - 1, j = y + 1; i >= 0 && j < n; ) {
                //grid[i][j] = 1;
                String tk = i + ":" + j;
                values.add(tk);
                lightMap.put(tk, lightMap.getOrDefault(tk, 0) + 1);
                i--;
                j++;
            }
            for (int i = y + 1; i < n; i++) {
                //grid[x][i] = 1;
                String tk = x + ":" + i;
                values.add(tk);
                lightMap.put(tk, lightMap.getOrDefault(tk, 0) + 1);
            }
            for (int i = x + 1, j = y + 1; i < n && j < n; ) {
                //grid[i][j] = 1;
                String tk = i + ":" + j;
                values.add(tk);
                lightMap.put(tk, lightMap.getOrDefault(tk, 0) + 1);
                i++;
                j++;
            }
            lampMap.put(key, values);
            lampCountMap.put(key, lampCountMap.getOrDefault(key, 0) + 1);
        }
        int[] res = new int[queries.length];
        int index = 0;
        for (int[] q : queries) {
            int x = q[0];
            int y = q[1];
            Integer c = lightMap.get(x + ":" + y);
            if (c == null || c <= 0) {
                res[index++] = 0;
            } else {
                res[index++] = 1;
            }
            for (int j = y - 1 >= 0 ? y - 1 : 0; j <= (y + 1 >= n - 1 ? n - 1 : y + 1); j++) {
                for (int i = x - 1 >= 0 ? x - 1 : 0; i <= (x + 1 >= n - 1 ? n - 1 : x + 1); i++) {
                    if (lampMap.containsKey(i + ":" + j)) {
                        List<String> values = lampMap.get(i + ":" + j);
                        Integer tc = lampCountMap.get(i + ":" + j);
                        for (String k : values) {
                            lightMap.put(k, lightMap.get(k) - tc);
                        }
                        lampMap.remove(i + ":" + j);
                        lampCountMap.remove(i + ":" + j);
                    }
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        RcbbPrinter.print(solution.gridIllumination(5, new int[][]{{0, 0}, {4, 4}}, new int[][]{{1, 1}, {1, 0}}));
        RcbbPrinter.print(solution.gridIllumination(5, new int[][]{{0, 0}, {4, 4}}, new int[][]{{1, 1}, {1, 1}}));
        RcbbPrinter.print(solution.gridIllumination(5, new int[][]{{0, 0}, {0, 4}}, new int[][]{{0, 4}, {0, 1}, {1, 4}}));
        RcbbPrinter.print(solution.gridIllumination(5, new int[][]{{0, 0}, {0, 1}, {0, 4}}, new int[][]{{0, 0}, {0, 1}, {0, 2}}));
        RcbbPrinter.print(solution.gridIllumination(6, new int[][]{{2, 5}, {4, 2}, {0, 3}, {0, 5}, {1, 4}, {4, 2}, {3, 3}, {1, 0}}, new int[][]{{4, 3}, {3, 1}, {5, 3}, {0, 5}, {4, 4}, {3, 3}}));
        RcbbPrinter.print(solution.gridIllumination(1, new int[][]{{0, 0}, {0, 0}}, new int[][]{{0, 0}, {0, 0}}));
        RcbbPrinter.print(solution.gridIllumination(100, new int[][]{{7, 55}, {53, 61}, {2, 82}, {67, 85}, {81, 75}, {38, 91}, {68, 0}, {60, 43}, {40, 19}, {12, 75}, {26, 2}, {24, 89}, {42, 81}, {60, 58}, {77, 72}, {33, 24}, {19, 93}, {7, 16}, {58, 54}, {78, 57}, {97, 49}, {65, 16}, {42, 75}, {90, 50}, {89, 34}, {76, 97}, {58, 23}, {62, 47}, {94, 28}, {88, 65}, {3, 87}, {81, 10}, {12, 81}, {44, 81}, {54, 92}, {90, 54}, {17, 54}, {27, 82}, {48, 15}, {8, 46}, {4, 99}, {15, 13}, {90, 77}, {2, 87}, {18, 33}, {52, 90}, {4, 95}, {57, 61}, {31, 22}, {32, 8}, {49, 26}, {24, 65}, {88, 55}, {88, 38}, {64, 76}, {94, 76}, {59, 12}, {41, 46}, {80, 28}, {38, 36}, {65, 67}, {75, 37}, {56, 97}, {83, 57}, {2, 4}, {44, 43}, {71, 90}, {62, 40}, {79, 94}, {81, 11}, {96, 34}, {38, 11}, {22, 3}, {54, 96}, {78, 33}, {54, 54}, {79, 98}, {1, 28}, {0, 32}, {37, 11}}, new int[][]{{24, 84}, {95, 68}, {80, 35}, {31, 53}, {69, 45}, {85, 29}, {87, 25}, {42, 47}, {7, 59}, {99, 3}, {31, 70}, {64, 62}, {44, 91}, {55, 25}, {15, 52}, {95, 33}, {21, 29}, {61, 34}, {93, 34}, {79, 27}, {30, 86}, {52, 0}, {18, 10}, {5, 1}, {40, 21}, {11, 48}, {55, 94}, {22, 42}, {81, 0}, {39, 43}, {5, 25}, {43, 29}, {45, 47}, {83, 93}, {77, 70}, {22, 63}, {30, 73}, {18, 48}, {39, 88}, {91, 47}}));
        /**
         * 1 0
         * 1 1
         * 1 1 0
         * 1 1 1
         * 1 0 1 1 0 1
         * 1 0
         * 1 1 1 1 1 1 1 1 1 1 1 1 1 0 1 1 1 1 1 1 0 1 1 1 1 1 1 1 1 1 0 0 1 1 1 1 1 1 0 1
         */
    }

}