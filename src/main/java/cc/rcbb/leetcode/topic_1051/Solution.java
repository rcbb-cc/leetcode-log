package cc.rcbb.leetcode.topic_1051;

import java.util.Arrays;

/**
 * 1051. 高度检查器
 * https://leetcode.cn/problems/height-checker/
 */
class Solution {
    public int heightChecker1(int[] heights) {
        int[] clone = heights.clone();
        Arrays.sort(clone);
        int count = 0;
        for (int i = 0; i < clone.length; i++) {
            if (clone[i] != heights[i]) {
                count++;
            }
        }
        return count;
    }

    public int heightChecker(int[] heights) {
        int[] arr = new int[101];
        for (int h : heights) {
            arr[h]++;
        }
        int count = 0;
        for (int i = 1, j = 0; i < arr.length; i++) {
            while (arr[i]-- > 0) {
                if (heights[j++] != i) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.heightChecker(new int[]{1, 1, 4, 2, 1, 3}));
        System.out.println(solution.heightChecker(new int[]{5, 1, 2, 3, 4}));
        System.out.println(solution.heightChecker(new int[]{1, 2, 3, 4, 5}));
    }
}