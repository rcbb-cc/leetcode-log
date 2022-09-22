package cc.rcbb.leetcode.topic_1640;

import java.util.HashMap;
import java.util.Map;

/**
 * 1640. 能否连接形成数组
 * https://leetcode.cn/problems/check-array-formation-through-concatenation/
 */
class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int n = arr.length, m = pieces.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(pieces[i][0], i);
        }
        for (int i = 0; i < n; ) {
            if (!map.containsKey(arr[i])) {
                return false;
            }
            Integer j = map.get(arr[i]);
            int[] piece = pieces[j];
            for (int k = 0; k < piece.length; k++) {
                if (arr[i] != piece[k]) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canFormArray(new int[]{15, 88}, new int[][]{{88}, {15}}));
        System.out.println(solution.canFormArray(new int[]{49, 18, 16}, new int[][]{{16, 18, 49}}));
        System.out.println(solution.canFormArray(new int[]{91, 4, 64, 78}, new int[][]{{78}, {4, 64}, {91}}));
    }
}