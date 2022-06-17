package cc.rcbb.leetcode.topic_1089;

import cc.rcbb.leetcode.common.RcbbPrinter;

/**
 * 1089. 复写零
 * https://leetcode.cn/problems/duplicate-zeros/
 */
class Solution {
    public void duplicateZeros1(int[] arr) {
        // 输入：[1,0,2,3,0,4,5,0]
        // 解释：[1,0,0,2,3,0,0,4]
        int n = arr.length - 1;
        for (int i = n; i >= 0; i--) {
            if (arr[i] == 0) {
                for (int j = n; j >= i; j--) {
                    if (j == i) {
                        arr[j] = 0;
                    } else {
                        arr[j] = arr[j - 1];
                    }
                }
            }
        }
    }

    public void duplicateZeros(int[] arr) {
        // 输入：[1,0,2,3,0,4,5,0]
        // 解释：[1,0,0,2,3,0,0,4]
        int n = arr.length;
        int top = 0;
        int i = -1;
        while (top < n) {
            i++;
            if (arr[i] != 0) {
                top++;
            } else {
                top += 2;
            }
        }
        int j = n - 1;
        if (top == n + 1) {
            arr[j] = 0;
            j--;
            i--;
        }
        while (j >= 0) {
            arr[j] = arr[i];
            j--;
            if (arr[i] == 0) {
                arr[j] = arr[i];
                j--;
            }
            i--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        arr = new int[]{1, 2, 3};
        solution.duplicateZeros(arr);
        RcbbPrinter.print(arr);
    }
}