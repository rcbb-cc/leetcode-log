package cc.rcbb.leetcode.topic_1109;

import cc.rcbb.leetcode.common.RcbbPrinter;

/**
 * 1109. 航班预订统计
 * https://leetcode-cn.com/problems/corporate-flight-bookings/
 */
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n];

        for (int i = 0; i < bookings.length; i++) {
            diff(diff, bookings[i][0], bookings[i][1], bookings[i][2]);
        }
        return result(diff);
    }

    public void diff(int[] diff, int i, int j, int val) {
        diff[i-1] += val;
        if (j < diff.length) {
            diff[j] -= val;
        }
    }

    public int[] result(int[] diff) {
        int[] sum = new int[diff.length];
        sum[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            sum[i] = sum[i - 1] + diff[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        //输入：bookings = [[1,2,10],[2,2,15]], n = 2 输出：[10,25]
        int[][] bookings = new int[][]{{1, 2, 10}, {2, 2, 15}};
        Solution solution = new Solution();
        int[] result = solution.corpFlightBookings(bookings, 2);
        RcbbPrinter.print(result);
    }

}