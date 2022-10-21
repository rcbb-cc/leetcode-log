package cc.rcbb.leetcode.topic_901;

import java.util.*;

/**
 * 901. 股票价格跨度
 * https://leetcode.cn/problems/online-stock-span/
 * <p>
 * 单调栈
 */
class StockSpanner {

    Deque<int[]> stack;
    int idx;

    public StockSpanner() {
        stack = new ArrayDeque<>();
        stack.push(new int[]{-1, Integer.MAX_VALUE});
        idx = -1;
    }

    public int next(int price) {
        idx++;
        while (price >= stack.peek()[1]) {
            stack.pop();
        }
        int ret = idx - stack.peek()[0];
        stack.push(new int[]{idx, price});
        return ret;
    }

    public static void main(String[] args) {
        StockSpanner spanner = new StockSpanner();
        System.out.println(spanner.next(100));
        System.out.println(spanner.next(80));
        System.out.println(spanner.next(60));
        System.out.println(spanner.next(70));
        System.out.println(spanner.next(60));
        System.out.println(spanner.next(75));
        System.out.println(spanner.next(85));
    }
}