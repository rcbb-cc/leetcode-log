package cc.rcbb.leetcode.topic_370;

import cc.rcbb.leetcode.common.RcbbPrinter;

/**
 * 370. 区间加法
 * https://leetcode-cn.com/problems/range-addition/description/
 */
public class Topic370 {

    int[] nums = null;
    Difference difference = null;


    int[] getModifiedArray(int length, int[][] updates) {
        nums = new int[length];
        difference = new Difference(nums);

        for (int i = 0; i < updates.length; i++) {
            difference.increment(updates[i][0], updates[i][1], updates[i][2]);
            System.out.println("updates[" + i + "] = {" + updates[i][0] + "," + updates[i][1] + "," + updates[i][2] + "}");
            RcbbPrinter.print(difference.diff);
        }

        return difference.result();
    }

    public static void main(String[] args) {
        int length = 5;
        int[][] arr = new int[][]{{1, 3, 2}, {2, 4, 3}, {0, 2, -2}};
        Topic370 t = new Topic370();
        int[] result = t.getModifiedArray(length, arr);
        RcbbPrinter.print(result);
    }

}
