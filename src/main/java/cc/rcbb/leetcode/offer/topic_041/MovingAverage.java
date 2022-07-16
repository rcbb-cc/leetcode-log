package cc.rcbb.leetcode.offer.topic_041;

import java.util.LinkedList;

/**
 * 剑指 Offer II 041. 滑动窗口的平均值
 * https://leetcode.cn/problems/qIsx9U/
 */
class MovingAverage {

    private LinkedList<Integer> list = new LinkedList<>();
    private int sum;
    private int size;

    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        list.add(val);
        sum += val;
        if (list.size() > size) {
            sum -= list.pollFirst();
        }
        return (double) sum / list.size();
    }

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1)); // 返回 1.0 = 1 / 1
        System.out.println(movingAverage.next(10)); // 返回 5.5 = (1 + 10) / 2
        System.out.println(movingAverage.next(3)); // 返回 4.66667 = (1 + 10 + 3) / 3
        System.out.println(movingAverage.next(5)); // 返回 6.0 = (10 + 3 + 5) / 3
    }
}