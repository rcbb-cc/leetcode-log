package cc.rcbb.leetcode.topic_1652;

import cc.rcbb.leetcode.common.RcbbPrinter;

/**
 * 1652. 拆炸弹
 * https://leetcode.cn/problems/defuse-the-bomb/
 * <p>
 * 前缀和
 */
class Solution {

    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        int[] sum = new int[2 * n + 1];
        for (int i = 1; i <= 2 * n; i++) {
            sum[i] += sum[i - 1] + code[(i - 1) % n];
        }
        for (int i = 1; i <= n; i++) {
            if (k < 0) {
                res[i - 1] = sum[i + n - 1] - sum[i + n + k - 1];
            } else {
                res[i - 1] = sum[i + k] - sum[i];
            }
        }
        return res;
    }

    public int[] decrypt1(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        if (k == 0) {
            for (int i = 0; i < n; i++) {
                res[i] = 0;
            }
        } else if (k < 0) {
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 1; j <= -k; j++) {
                    int t = (i - j + n) % n;
                    sum += code[t];
                }
                res[i] = sum;
            }
        } else if (k > 0) {
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 1; j <= k; j++) {
                    int t = (i + j) % n;
                    sum += code[t];
                }
                res[i] = sum;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        RcbbPrinter.print(solution.decrypt(new int[]{5, 7, 1, 4}, 3));
        RcbbPrinter.print(solution.decrypt(new int[]{1, 2, 3, 4}, 0));
        RcbbPrinter.print(solution.decrypt(new int[]{2, 4, 9, 3}, -2));
    }
}