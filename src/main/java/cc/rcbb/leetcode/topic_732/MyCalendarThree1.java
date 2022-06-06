package cc.rcbb.leetcode.topic_732;

import java.util.Map;
import java.util.TreeMap;

/**
 * 732. 我的日程安排表 III
 * https://leetcode.cn/problems/my-calendar-iii/
 */
class MyCalendarThree1 {

    private Map<Integer, Integer> map;

    public MyCalendarThree1() {
        map = new TreeMap<>();
    }

    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int max = 0;
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            max += entry.getValue();
            ans = Math.max(max, ans);
        }
        return ans;
    }
}