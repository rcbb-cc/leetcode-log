package cc.rcbb.leetcode.topic_927;

import cc.rcbb.leetcode.common.RcbbPrinter;

import java.util.Arrays;

/**
 * 927. 三等分
 * https://leetcode.cn/problems/three-equal-parts/
 */
class Solution {
    public int[] threeEqualParts(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        if (sum % 3 != 0) {
            return new int[]{-1, -1};
        }
        if (sum == 0) {
            return new int[]{0, 2};
        }

        // 最后检查「三段中 1 的间隔位是否相同，后缀 0 个数是否相同」
        int partial = sum / 3;
        int first = 0, second = 0, third = 0, cur = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                if (cur == 0) {
                    first = i;
                } else if (cur == partial) {
                    second = i;
                } else if (cur == 2 * partial) {
                    third = i;
                }
                cur++;
            }
        }

        int len = arr.length - third;
        if (first + len <= second && second + len <= third) {
            int i = 0;
            while (third + i < arr.length) {
                if (arr[first + i] != arr[second + i] ||
                        arr[first + i] != arr[third + i]) {
                    return new int[]{-1, -1};
                }
                i++;
            }
            return new int[]{first + len - 1, second + len};
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        RcbbPrinter.print(solution.threeEqualParts(new int[]{1, 0, 1, 0, 1}));
        RcbbPrinter.print(solution.threeEqualParts(new int[]{1, 1, 0, 1, 1}));
        RcbbPrinter.print(solution.threeEqualParts(new int[]{1, 1, 0, 0, 1}));
    }
}