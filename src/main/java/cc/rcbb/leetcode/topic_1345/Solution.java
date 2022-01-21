package cc.rcbb.leetcode.topic_1345;

import java.util.*;

/**
 * 1345. 跳跃游戏 IV
 * https://leetcode-cn.com/problems/jump-game-iv/
 */
class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        boolean[] visit = new boolean[n];
        visit[0] = true;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int index = temp[0];
            int step = temp[1];
            if (index == n - 1) {
                return step;
            }
            step++;
            if (index + 1 < n && visit[index + 1] == false) {
                visit[index + 1] = true;
                queue.offer(new int[]{index + 1, step});
            }
            if (index - 1 > 0 && visit[index - 1] == false) {
                visit[index - 1] = true;
                queue.offer(new int[]{index - 1, step});
            }
            if (map.get(arr[index]) != null) {
                for (int i : map.get(arr[index])) {
                    if (visit[i] == false) {
                        if (i == n - 1) {
                            return step;
                        }
                        visit[i] = true;
                        queue.offer(new int[]{i, step});
                    }
                }
                map.remove(arr[index]);
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入：arr = [100,-23,-23,404,100,23,23,23,3,404]
        //输出：3
        //解释：那你需要跳跃 3 次，下标依次为 0 --> 4 --> 3 --> 9 。下标 9 为数组的最后一个元素的下标。
        System.out.println(solution.minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404}));
        //0
        System.out.println(solution.minJumps(new int[]{7}));
        //输入：arr = [7,6,9,6,9,6,9,7]
        //输出：1
        //解释：你可以直接从下标 0 处跳到下标 7 处，也就是数组的最后一个元素处。
        System.out.println(solution.minJumps(new int[]{7, 6, 9, 6, 9, 6, 9, 7}));
        //输入：arr = [6,1,9]
        //输出：2
        System.out.println(solution.minJumps(new int[]{6, 1, 9}));
        //输入：arr = [11,22,7,7,7,7,7,7,7,22,13]
        //输出：3
        System.out.println(solution.minJumps(new int[]{11, 22, 7, 7, 7, 7, 7, 7, 7, 22, 13}));
    }
}