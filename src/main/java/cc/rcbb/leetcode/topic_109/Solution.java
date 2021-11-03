package cc.rcbb.leetcode.topic_109;

import cc.rcbb.leetcode.common.RcbbPrinter;

/**
 * 1094. 拼车
 */
public class Solution {

    int[] diff = null;

    public void increment(int i, int j, int val) {
        if (i < diff.length) {
            diff[i] += val;
        }
        if (j + 1 < diff.length) {
            diff[j + 1] -= val;
        }
    }

    public int[] getResult() {
        int[] result = new int[diff.length];
        result[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            result[i] = result[i - 1] + diff[i];
        }
        return result;
    }


    public boolean carPooling(int[][] trips, int capacity) {

        diff = new int[capacity];

        for (int i = 0; i < trips.length; i++) {
            System.out.println("trips[" + i + "] = {" + trips[i][0] + "," + trips[i][1] + "," + trips[i][2] + "}");
            this.increment(trips[i][1], trips[i][2], trips[i][0]);
            RcbbPrinter.print(diff);
        }
        int[] resultArray = getResult();
        RcbbPrinter.print(resultArray);
        for (int i = 0; i < resultArray.length; i++) {
            if (resultArray[i] > capacity) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] trips = new int[][]{{3,2,7}, {3,7,9}, {8,3,9}};
        int capacity = 11;

        Solution s = new Solution();
        boolean b = s.carPooling(trips, capacity);
        System.out.println(" flag = " + b);
    }
}