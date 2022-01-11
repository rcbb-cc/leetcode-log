package cc.rcbb.leetcode.topic_1036;

import cc.rcbb.leetcode.common.RcbbPrinter;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * 1036. 逃离大迷宫
 * https://leetcode-cn.com/problems/escape-a-large-maze/
 */
class Solution {
    int bound = 1000000;
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int step = 0;

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if (blocked.length < 2) {
            return true;
        }
        Set<String> set = new HashSet<>();
        for (int[] arr : blocked) {
            set.add(arr[0] + "" + arr[1]);
        }
        step = blocked.length * (blocked.length - 1) / 2;
        return f(source, target, set) && f(target, source, set);
    }

    public boolean f(int[] source, int[] target, Set<String> set) {
        Set<String> visit = new HashSet<>();
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(source);
        visit.add(source[0] + "" + source[1]);
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int x = arr[0];
            int y = arr[1];
            if (x == target[0] && y == target[1]) {
                return true;
            }
            if (visit.size() > step) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = x + dir[i][0];
                int nextY = y + dir[i][1];
                String key = nextX + "" + nextY;
                if (nextX >= 0 && nextX < bound &&
                        nextY >= 0 && nextY < bound &&
                        !visit.contains(key) &&
                        !set.contains(key)) {
                    queue.offer(new int[]{nextX, nextY});
                    visit.add(key);
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.isEscapePossible(new int[][]{{0, 1}, {1, 0}}, new int[]{0, 0}, new int[]{0, 2}));

        //[[10,9],[9,10],[10,11],[11,10]]
        //[0,0]
        //[10,10]
        System.out.println(solution.isEscapePossible(new int[][]{{10, 9}, {9, 10}, {10, 11}, {11, 10}}, new int[]{0, 0}, new int[]{10, 10}));

        int[][] arr = new int[12][12];
        arr[10][9] = 1;
        arr[9][10] = 1;
        arr[10][11] = 1;
        arr[11][10] = 1;
        arr[10][10] = 2;
        RcbbPrinter.print(arr);
    }
}