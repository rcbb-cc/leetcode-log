package cc.rcbb.leetcode.topic_933;


import java.util.*;

/**
 * 933. 最近的请求次数
 * https://leetcode-cn.com/problems/number-of-recent-calls/
 */
class RecentCounter {

    /*List<Integer> list;

    public RecentCounter() {
        list = new LinkedList<>();
    }

    public int ping(int t) {
        int count = 1;
        for (int next : list) {
            if (next >= t - 3000 && next <= t) {
                count++;
            }
        }
        list.add(t);
        return count;
    }*/

    Queue<Integer> queue;

    public RecentCounter() {
        queue = new ArrayDeque<Integer>();
    }

    public int ping(int t) {
        queue.offer(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        recentCounter.ping(1);     // requests = [1]，范围是 [-2999,1]，返回 1
        recentCounter.ping(100);   // requests = [1, 100]，范围是 [-2900,100]，返回 2
        recentCounter.ping(3001);  // requests = [1, 100, 3001]，范围是 [1,3001]，返回 3
        recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002]，范围是 [2,3002]，返回 3
    }
}

