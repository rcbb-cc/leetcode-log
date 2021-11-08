package cc.rcbb.leetcode.topic_1094;

import cc.rcbb.leetcode.common.RcbbPrinter;

/**
 * 1094. 拼车
 * https://leetcode-cn.com/problems/car-pooling/
 */
public class Solution {

    public boolean carPooling(int[][] trips, int capacity) {
        // 求出最后的站点
        int max = 0;
        for (int i = 0; i < trips.length; i++) {
            if (trips[i][2] > max) {
                max = trips[i][2];
            }
        }
        int[] arr = new int[max + 1];
        for (int i = 0; i < trips.length; i++) {
            diff(arr, trips[i][1], trips[i][2], trips[i][0]);
        }
        int[] result = result(arr);
        for (int i = 0; i < result.length; i++) {
            if (result[i] > capacity) {
                return false;
            }
        }
        return true;
    }

    public void diff(int[] diff, int i, int j, int val) {
        diff[i] += val;
        diff[j] -= val;
        RcbbPrinter.print(diff);
    }

    public int[] result(int[] diff) {
        int[] result = new int[diff.length];
        result[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            result[i] = result[i - 1] + diff[i];
        }
        RcbbPrinter.print(result);
        return result;
    }

    public static void main(String[] args) {
        // 输入：trips = [[2,1,5],[3,3,7]], capacity = 4 输出：false
        int[][] trips = new int[][]{{2, 1, 5}, {3, 3, 7}};
        int capacity = 4;

        // 输入：trips = [[2,1,5],[3,3,7]], capacity = 5 输出：true
        //int[][] trips = new int[][]{{2, 1, 5}, {3, 3, 7}};
        //int capacity = 5;

        // 输入：trips = [[2,1,5],[3,5,7]], capacity = 3 输出：true
        //int[][] trips = new int[][]{{2, 1, 5}, {3, 5, 7}};
        //int capacity = 3;

        // 输入：trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11 输出：true
        //int[][] trips = new int[][]{{3, 2, 7}, {3, 7, 9}, {8, 3, 9}};
        //int capacity = 11;
        //int[][] trips = new int[][]{{3, 2, 7}, {3, 7, 9}, {8, 3, 9}};
        //int[][] trips = new int[][]{{2, 1, 5}, {3, 5, 7}};
        //int[][] trips = new int[][]{{3, 3, 5}, {4, 5, 6}, {1, 2, 7}, {3, 2, 8}, {10, 5, 9}, {2, 5, 9}, {1, 2, 5}};
        //int capacity = 19;

        Solution s = new Solution();
        boolean b = s.carPooling(trips, capacity);
        System.out.println("flag = " + b);
    }
}