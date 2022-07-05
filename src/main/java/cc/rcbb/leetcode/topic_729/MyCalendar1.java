package cc.rcbb.leetcode.topic_729;

import java.util.ArrayList;
import java.util.List;
/**
 * 729. 我的日程安排表 I
 * https://leetcode.cn/problems/my-calendar-i/
 */
class MyCalendar1 {

    List<int[]> list;

    public MyCalendar1() {
        list = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] arr : list) {
            if (arr[0] < end && start < arr[1]) {
                return false;
            }
        }
        list.add(new int[]{start, end});
        return true;
    }
}
