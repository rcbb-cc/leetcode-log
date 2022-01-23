package cc.rcbb.leetcode.topic_2034;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 2034. 股票价格波动
 * https://leetcode-cn.com/problems/stock-price-fluctuation/
 */
class StockPrice {
    // key：时间 value：价格
    private Map<Integer, Integer> map;
    // 价格出现的次数
    private TreeMap<Integer, Integer> countMap;
    // 最大的时间
    private int maxTimestamp;

    public StockPrice() {
        map = new HashMap<>();
        countMap = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        // 记录最大的时间
        if (timestamp > maxTimestamp) {
            maxTimestamp = timestamp;
        }
        // 存储价格出现的次数
        countMap.put(price, countMap.getOrDefault(price, 0) + 1);
        // 存储时间与价格的关系
        Integer oldPrice = map.put(timestamp, price);
        if (oldPrice != null &&
                countMap.containsKey(oldPrice)) {
            Integer count = countMap.get(oldPrice);
            if (count == 1) {
                // 如果价格被覆盖且数目为1，则删除这个价格
                countMap.remove(oldPrice);
            } else {
                countMap.put(oldPrice, count - 1);
            }
        }
    }

    public int current() {
        // 最大的时间对应的着当前的价格
        return map.get(maxTimestamp);
    }

    public int maximum() {
        // TreeMap的key为价格，lastKey为最大的价格
        return countMap.lastKey();
    }

    public int minimum() {
        // TreeMap的key为价格，firstKey为最小的价格
        return countMap.firstKey();
    }

    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();

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