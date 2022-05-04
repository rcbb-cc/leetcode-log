package cc.rcbb.leetcode.topic_1823;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1823. 找出游戏的获胜者
 * https://leetcode-cn.com/problems/find-the-winner-of-the-circular-game/
 */
class Solution {
    public int findTheWinner1(int n, int k) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        while (queue.size() > 1) {
            for (int i = 1; i < k; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
        }
        return queue.peek();
    }

    /**
     * 第一轮会删除第 k 个人，接下来就是 n-1 个人来进行游戏
     * 由于删除了第 k 个人，n-1 个人的游戏是从原来的第 k+1 个人开始的。
     * 也就是原来的编号和新的编号中有一个偏差 k。
     * 从 [0,n-1] 来看的话，f(n,k)=(f(n-1,k) + k)%n;
     */
    public int findTheWinner(int n, int k) {
        int pos = 0;
        for (int i = 2; i <= n; i++) {
            pos = (pos + k) % i;
        }
        return pos + 1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTheWinner(5, 2));
        System.out.println(solution.findTheWinner(6, 5));
    }
}