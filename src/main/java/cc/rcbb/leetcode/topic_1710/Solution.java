package cc.rcbb.leetcode.topic_1710;

import java.util.Arrays;

/**
 * 1710. 卡车上的最大单元数
 * https://leetcode.cn/problems/maximum-units-on-a-truck/
 * <p>
 * 模拟
 */
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int res = 0;
        for (int[] box : boxTypes) {
            if (box[0] < truckSize) {
                res += box[0] * box[1];
                truckSize -= box[0];
            } else {
                res += truckSize * box[1];
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumUnits(new int[][]{{1, 3}, {2, 2}, {3, 1}}, 4));
        System.out.println(solution.maximumUnits(new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}}, 10));
    }
}