package cc.rcbb.leetcode.topic_1606;

import cc.rcbb.leetcode.common.RcbbPrinter;

import java.util.*;

/**
 * 1606. 找到处理最多请求的服务器
 * https://leetcode-cn.com/problems/find-servers-that-handled-most-number-of-requests/
 */
class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        PriorityQueue<Integer> available = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            available.offer(i);
        }
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] requests = new int[k];
        for (int i = 0; i < arrival.length; i++) {
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                int id = busy.poll()[1];
                // 保证得到的是一个不小于 i 的且与 id 同余的数
                available.offer(i + ((id - i) % k + k) % k);
            }
            if (available.isEmpty()) {
                continue;
            }
            Integer p = available.poll() % k;
            requests[p]++;
            busy.offer(new int[]{arrival[i] + load[i], p});
        }
        int maxRequest = Arrays.stream(requests).max().getAsInt();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (requests[i] == maxRequest) {
                res.add(i);
            }
        }
        return res;
    }

    public List<Integer> busiestServers1(int k, int[] arrival, int[] load) {
        //空闲服务器
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }
        //正在处理请求的服务器[处理结束时间,编号]
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        //记录服务器处理的请求数目
        int[] requests = new int[k];
        for (int i = 0; i < arrival.length; i++) {
            //如果处理请求的服务器不为空，判断队首对应的结束时间是否小于请求到达时间
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                //将服务器的编号放入空闲服务器中
                available.add(busy.poll()[1]);
            }
            //无空闲服务器，请求丢弃
            if (available.isEmpty()) {
                continue;
            }
            //查找大于或等于 i%k 的第一个元素
            Integer p = available.ceiling(i % k);
            if (p == null) {
                //如果未找到，则取编号最小的服务器
                p = available.first();
            }
            requests[p]++;
            busy.offer(new int[]{arrival[i] + load[i], p});
            available.remove(p);
        }
        int maxRequest = Arrays.stream(requests).max().getAsInt();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (requests[i] == maxRequest) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入：k = 3, arrival = [1,2,3,4,5], load = [5,2,3,3,3]
        //输出：[1]
        //解释：
        //所有服务器一开始都是空闲的。
        //前 3 个请求分别由前 3 台服务器依次处理。
        //请求 3 进来的时候，服务器 0 被占据，所以它呗安排到下一台空闲的服务器，也就是服务器 1 。
        //请求 4 进来的时候，由于所有服务器都被占据，该请求被舍弃。
        //服务器 0 和 2 分别都处理了一个请求，服务器 1 处理了两个请求。所以服务器 1 是最忙的服务器。
        RcbbPrinter.print(solution.busiestServers(3, new int[]{1, 2, 3, 4, 5}, new int[]{5, 2, 3, 3, 3}));
        //输入：k = 3, arrival = [1,2,3,4], load = [1,2,1,2]
        //输出：[0]
        //解释：
        //前 3 个请求分别被前 3 个服务器处理。
        //请求 3 进来，由于服务器 0 空闲，它被服务器 0 处理。
        //服务器 0 处理了两个请求，服务器 1 和 2 分别处理了一个请求。所以服务器 0 是最忙的服务器。
        RcbbPrinter.print(solution.busiestServers(3, new int[]{1, 2, 3, 4}, new int[]{1, 2, 1, 2}));
        //输入：k = 3, arrival = [1,2,3], load = [10,12,11]
        //输出：[0,1,2]
        //解释：每个服务器分别处理了一个请求，所以它们都是最忙的服务器。
        RcbbPrinter.print(solution.busiestServers(3, new int[]{1, 2, 3}, new int[]{10, 12, 11}));
        //输入：k = 3, arrival = [1,2,3,4,8,9,10], load = [5,2,10,3,1,2,2]
        //输出：[1]
        RcbbPrinter.print(solution.busiestServers(3, new int[]{1, 2, 3, 4, 8, 9, 10}, new int[]{5, 2, 10, 3, 1, 2, 2}));
        //输入：k = 1, arrival = [1], load = [1]
        //输出：[0]
        RcbbPrinter.print(solution.busiestServers(1, new int[]{1}, new int[]{1}));
    }
}