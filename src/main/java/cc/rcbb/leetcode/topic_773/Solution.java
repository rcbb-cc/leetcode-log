package cc.rcbb.leetcode.topic_773;

import java.util.*;

/**
 * 773. 滑动谜题
 * https://leetcode-cn.com/problems/sliding-puzzle/
 */
class Solution {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
        }
        // 记录可以移动的索引位置
        int[][] stepArray = new int[][]{
                {1, 3},
                {0, 2, 4},
                {1, 5},
                {0, 4},
                {1, 3, 5},
                {2, 4}
        };
        Queue<String> q = new LinkedList<>();
        q.offer(sb.toString());
        Set<String> visited = new HashSet<>();
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String str = q.poll();
                if (target.equals(str)) {
                    return count;
                }
                // 找到0的下标
                int index = str.indexOf("0");
                for (int k : stepArray[index]) {
                    // 替换位置
                    char[] chars = str.toCharArray();
                    chars[index] = chars[k];
                    chars[k] = '0';
                    String newStr = new String(chars);
                    // 不走回头路
                    if (visited.contains(newStr)) {
                        continue;
                    }
                    q.offer(newStr);
                    visited.add(newStr);
                }
            }
            count++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[][] board = new int[][]{{1, 2, 3}, {4, 0, 5}};
        int[][] board = new int[][]{{1, 2, 3}, {5, 4, 0}};
        //int[][] board = new int[][]{{3,2,4}, {1,5,0}};
        System.out.println(solution.slidingPuzzle(board));

    }
}