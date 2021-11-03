package cc.rcbb.leetcode.topic_109;

import cc.rcbb.leetcode.common.RcbbPrinter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1094. 拼车
 */
public class Solution1 {

    public boolean carPooling(int[][] trips, int capacity) {
        // 根据起始站点排序
        Arrays.sort(trips, (a, b) -> {
            return a[1] - b[1];
        });

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < trips.length; i++) {
            //System.out.println("trips[" + i + "] = {" + trips[i][0] + "," + trips[i][1] + "," + trips[i][2] + "}");
            for (int j = trips[i][1]; j < trips[i][2]; j++) {
                map.put(j, map.getOrDefault(j, 0) + trips[i][0]);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
            if (entry.getValue() > capacity) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //int[][] trips = new int[][]{{3, 2, 7}, {3, 7, 9}, {8, 3, 9}};
        //int[][] trips = new int[][]{{2, 1, 5}, {3, 5, 7}};
        int[][] trips = new int[][]{{3, 3, 5}, {4, 5, 6}, {1, 2, 7}, {3, 2, 8}, {10, 5, 9}, {2, 5, 9}, {1, 2, 5}};
        int capacity = 19;

        Solution1 s = new Solution1();
        boolean b = s.carPooling(trips, capacity);
        System.out.println("flag = " + b);
    }
}