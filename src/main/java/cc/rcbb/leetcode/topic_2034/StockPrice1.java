package cc.rcbb.leetcode.topic_2034;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 2034. 股票价格波动
 * https://leetcode-cn.com/problems/stock-price-fluctuation/
 */
class StockPrice1 {

    private static class Price {
        boolean error;
        int price;

        public Price(int price) {
            this.error = false;
            this.price = price;
        }
    }

    private Map<Integer, Price> map;

    private PriorityQueue<Price> minHeap;

    private PriorityQueue<Price> maxHeap;

    private int maxTimestamp;

    public StockPrice1() {
        this.map = new HashMap<>();
        this.minHeap = new PriorityQueue<>((p1, p2) -> p1.price - p2.price);
        this.maxHeap = new PriorityQueue<>((p1, p2) -> p2.price - p1.price);
    }

    public void update(int timestamp, int price) {
        if (timestamp > maxTimestamp) {
            maxTimestamp = timestamp;
        }

        Price p = new Price(price);
        Price oldP = map.put(timestamp, p);
        if (oldP != null) {
            oldP.error = true;
        }
        minHeap.offer(p);
        maxHeap.offer(p);
    }

    public int current() {
        // 最大的时间对应的着当前的价格
        return map.get(maxTimestamp).price;
    }

    public int maximum() {
        while (!maxHeap.isEmpty() &&
                maxHeap.peek().error) {
            maxHeap.poll();
        }
        return maxHeap.peek().price;
    }

    public int minimum() {
        while (!minHeap.isEmpty() &&
                minHeap.peek().error) {
            minHeap.poll();
        }
        return minHeap.peek().price;
    }

    public static void main(String[] args) {
        StockPrice1 stockPrice = new StockPrice1();

        // ["StockPrice", "update", "update", "current", "maximum", "update", "maximum", "update", "minimum"]
        // [[], [1, 10], [2, 5], [], [], [1, 3], [], [4, 2], []]
        // 输出：
        // [null, null, null, 5, 10, null, 5, null, 2]
        stockPrice.update(1, 10);
        stockPrice.update(2, 5);
        System.out.println(stockPrice.current());
        System.out.println(stockPrice.maximum());
        stockPrice.update(1, 3);
        System.out.println(stockPrice.maximum());
        stockPrice.update(4, 2);
        System.out.println(stockPrice.minimum());
    }
}