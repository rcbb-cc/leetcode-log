package cc.rcbb.leetcode.topic_2055;

import cc.rcbb.leetcode.common.RcbbPrinter;

/**
 * 2055. 蜡烛之间的盘子
 * https://leetcode-cn.com/problems/plates-between-candles/
 */
class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] preSum = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*') {
                sum++;
            }
            preSum[i] = sum;
        }

        int[] leftArray = new int[n];
        int left = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|') {
                left = i;
            }
            leftArray[i] = left;
        }

        int[] rightArray = new int[n];
        int right = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                right = i;
            }
            rightArray[i] = right;
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = rightArray[queries[i][0]];
            int y = leftArray[queries[i][1]];
            if (x == -1 || y == -1 || x >= y) {
                res[i] = 0;
            } else {
                res[i] = preSum[y] - preSum[x];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入：s = "**|**|***|", queries = [[2,5],[5,9]]
        //输出：[2,3]
        //解释：
        //- queries[0] 有两个盘子在蜡烛之间。
        //- queries[1] 有三个盘子在蜡烛之间。
        RcbbPrinter.print(solution.platesBetweenCandles("**|**|***|", new int[][]{{2, 5}, {5, 9}}));
        //输入：s = "***|**|*****|**||**|*", queries = [[1,17],[4,5],[14,17],[5,11],[15,16]]
        //输出：[9,0,0,0,0]
        //解释：
        //- queries[0] 有 9 个盘子在蜡烛之间。
        //- 另一个查询没有盘子在蜡烛之间。
        RcbbPrinter.print(solution.platesBetweenCandles("***|**|*****|**||**|*", new int[][]{{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}}));
    }
}