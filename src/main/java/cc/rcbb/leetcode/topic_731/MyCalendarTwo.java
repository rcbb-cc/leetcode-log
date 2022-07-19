package cc.rcbb.leetcode.topic_731;

import java.util.ArrayList;
import java.util.List;

/**
 * 731. 我的日程安排表 II
 * https://leetcode.cn/problems/my-calendar-ii/
 */
class MyCalendarTwo {

    List<int[]> booked;
    List<int[]> overlaps;

    public MyCalendarTwo() {
        booked = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] arr : overlaps) {
            int l = arr[0], r = arr[1];
            if (l < end && start < r) {
                return false;
            }
        }
        for (int[] arr : booked) {
            int l = arr[0], r = arr[1];
            if (l < end && start < r) {
                overlaps.add(new int[]{Math.max(l, start), Math.min(r, end)});
            }
        }
        booked.add(new int[]{start, end});
        return true;
    }
}