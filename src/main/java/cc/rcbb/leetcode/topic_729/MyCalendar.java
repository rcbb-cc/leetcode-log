package cc.rcbb.leetcode.topic_729;

import java.util.HashSet;
import java.util.Set;

/**
 * 729. 我的日程安排表 I
 * https://leetcode.cn/problems/my-calendar-i/
 */
class MyCalendar {

    Set<Integer> tree;
    Set<Integer> lazy;

    public MyCalendar() {
        tree = new HashSet<>();
        lazy = new HashSet<>();
    }

    public boolean book(int start, int end) {
        if (query(start, end - 1, 0, 1000000000, 1)) {
            return false;
        }
        update(start, end - 1, 0, 1000000000, 1);
        return true;
    }

    public boolean query(int start, int end, int l, int r, int idx) {
        if (start > r || end < l) {
            return false;
        }
        if (lazy.contains(idx)) {
            return true;
        }
        if (start <= l && r <= end) {
            return tree.contains(idx);
        } else {
            int mid = (l + r) >> 1;
            if (end <= mid) {
                return query(start, end, l, mid, 2 * idx);
            } else if (start > mid) {
                return query(start, end, mid + 1, r, 2 * idx + 1);
            } else {
                return query(start, end, l, mid, 2 * idx) | query(start, end, mid + 1, r, 2 * idx + 1);
            }
        }
    }

    public void update(int start, int end, int l, int r, int idx) {
        if (r < start || end < l) {
            return;
        }
        if (start <= l && r <= end) {
            tree.add(idx);
            lazy.add(idx);
        } else {
            int mid = (l + r) / 2;
            update(start, end, l, mid, 2 * idx);
            update(start, end, mid + 1, r, 2 * idx + 1);
            tree.add(idx);
        }
    }

    public static void main(String[] args) {
        // 输入：
        // ["MyCalendar", "book", "book", "book"]
        // [[], [10, 20], [15, 25], [20, 30]]
        // 输出：
        // [null, true, false, true]
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20)); // return True
        System.out.println(myCalendar.book(15, 25)); // return False ，这个日程安排不能添加到日历中，因为时间 15 已经被另一个日程安排预订了。
        System.out.println(myCalendar.book(20, 30)); // return True ，这个日程安排可以添加到日历中，因为第一个日程安排预订的每个时间都小于 20 ，且不包含时间 20 。
    }
}
