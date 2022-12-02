package cc.rcbb.leetcode.topic_1769;

import cc.rcbb.leetcode.common.RcbbPrinter;

/**
 * 1769. 移动所有球到每个盒子所需的最小操作数
 * https://leetcode.cn/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
 * <p>
 * 模拟
 */
class Solution {
    public int[] minOperations(String boxes) {
        int left = boxes.charAt(0) - '0', right = 0, operations = 0;
        int n = boxes.length();
        for (int i = 1; i < n; i++) {
            if (boxes.charAt(i) == '1') {
                right++;
                operations += i;
            }
        }
        int[] res = new int[n];
        res[0] = operations;
        for (int i = 1; i < n; i++) {
            operations += left - right;
            if (boxes.charAt(i) == '1') {
                left++;
                right--;
            }
            res[i] = operations;
        }
        return res;
    }


    public int[] minOperations1(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && boxes.charAt(j) == '1') {
                    sum += Math.abs(i - j) * (boxes.charAt(j) - '0');
                }
            }
            answer[i] = sum;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        RcbbPrinter.print(solution.minOperations("110"));
        RcbbPrinter.print(solution.minOperations("001011"));
    }
}