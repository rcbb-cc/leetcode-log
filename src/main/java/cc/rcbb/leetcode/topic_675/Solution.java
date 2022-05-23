package cc.rcbb.leetcode.topic_675;

import java.util.*;

/**
 * 675. 为高尔夫比赛砍树
 * https://leetcode.cn/problems/cut-off-trees-for-golf-event/
 */
class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        List<int[]> trees = new ArrayList<>();
        int row = forest.size();
        int col = forest.get(0).size();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (forest.get(i).get(j) > 1) {
                    trees.add(new int[]{i, j});
                }
            }
        }
        Collections.sort(trees, (a, b) -> forest.get(a[0]).get(a[1]) - forest.get(b[0]).get(b[1]));

        int cx = 0, cy = 0, ans = 0;
        for (int i = 0; i < trees.size(); i++) {
            int steps = bfs(forest, cx, cy, trees.get(i)[0], trees.get(i)[1]);
            if (steps == -1) {
                return -1;
            }
            ans += steps;
            cx = trees.get(i)[0];
            cy = trees.get(i)[1];
        }
        return ans;
    }

    int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int bfs(List<List<Integer>> forest, int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) {
            return 0;
        }
        int row = forest.size();
        int col = forest.get(0).size();

        int step = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        queue.offer(new int[]{sx, sy});
        visited[sx][sy] = true;
        while (!queue.isEmpty()) {
            step++;
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int[] cell = queue.poll();
                int cx = cell[0], cy = cell[1];
                for (int j = 0; j < 4; j++) {
                    int nx = cx + dir[j][0];
                    int ny = cy + dir[j][1];
                    if (nx >= 0 && nx < row && ny >= 0 && ny < col) {
                        if (!visited[nx][ny] && forest.get(nx).get(ny) > 0) {
                            if (nx == tx && ny == ty) {
                                return step;
                            }
                            queue.offer(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 输入：forest = [[1,2,3],[0,0,4],[7,6,5]]
        // 输出：6
        System.out.println(solution.cutOffTree(List.of(List.of(1, 2, 3), List.of(0, 0, 4), List.of(7, 6, 5))));
        // 输入：forest = [[1,2,3],[0,0,0],[7,6,5]]
        // 输出：-1
        // 解释：由于中间一行被障碍阻塞，无法访问最下面一行中的树。
        System.out.println(solution.cutOffTree(List.of(List.of(1, 2, 3), List.of(0, 0, 0), List.of(7, 6, 5))));
        // 输入：forest = [[2,3,4],[0,0,5],[8,7,6]]
        // 输出：6
        // 解释：可以按与示例 1 相同的路径来砍掉所有的树。
        // (0,0) 位置的树，可以直接砍去，不用算步数。
        System.out.println(solution.cutOffTree(List.of(List.of(2, 3, 4), List.of(0, 0, 5), List.of(7, 6, 5))));
    }

}