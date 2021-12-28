package cc.rcbb.leetcode.topic_lcp_30;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * LCP 30. 魔塔游戏
 * https://leetcode-cn.com/problems/p0NxJO/
 */
class Solution {
    public int magicTower(int[] nums) {
        // 1.总和小于0，则代表怎么移动也访问不了全部房间
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum < 0) {
            return -1;
        }
        long blood = 1;
        int count = 0;
        Queue<Integer> min = new PriorityQueue<>();
        for (int n : nums) {
            if (n < 0) {
                min.offer(n);
            }
            blood += n;
            if (blood <= 0 && !min.isEmpty()) {
                // 加回之前扣的
                blood -= min.poll();
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.magicTower(new int[]{100, 100, 100, -250, -60, -140, -50, -50, 100, 150}));
        System.out.println(solution.magicTower(new int[]{-200, -300, 400, 0}));
        System.out.println(solution.magicTower(new int[]{-1, -1, 10}));
    }
}