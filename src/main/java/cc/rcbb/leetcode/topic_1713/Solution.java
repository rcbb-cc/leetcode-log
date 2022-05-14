package cc.rcbb.leetcode.topic_1713;

import java.util.*;

/**
 * 1713. 得到子序列的最少操作次数
 * https://leetcode-cn.com/problems/minimum-operations-to-make-a-subsequence/
 */
class Solution {
    public int minOperations(int[] target, int[] arr) {
        int n = target.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            // 记录 target[i] 的下标位置
            map.put(target[i], i);
        }
        List<Integer> list = new ArrayList<>();
        for (int val : arr) {
            // 判断是否含有该数值
            if (map.containsKey(val)) {
                int idx = map.get(val);
                int it = binarySearch(list, idx);
                if (it != list.size()) {
                    list.set(it, idx);
                } else {
                    // list 中的值都小于 idx
                    list.add(idx);
                }
            }
        }
        return n - list.size();
    }

    public int binarySearch(List<Integer> list, int target) {
        int size = list.size();
        if (size == 0 || list.get(size - 1) < target) {
            return size;
        }
        int left = 0, right = size - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int minOperations1(int[] target, int[] arr) {
        int m = target.length;
        int n = arr.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (target[i - 1] == arr[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return m - dp[m][n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // System.out.println(solution.minOperations(new int[]{5, 1, 3}, new int[]{9, 4, 2, 3, 4}));
        System.out.println(solution.minOperations(new int[]{6, 4, 8, 1, 3, 2}, new int[]{4, 7, 6, 2, 3, 8, 6, 1}));
    }
}