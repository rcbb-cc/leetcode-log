package cc.rcbb.leetcode.topic_1936;


/**
 * 1936. 新增的最少台阶数
 * https://leetcode-cn.com/problems/add-minimum-number-of-rungs/
 */
class Solution {

    /**
     * 贪心处理方式，每次需要插入时都插最大值
     */
    public int addRungs(int[] rungs, int dist) {
        int count = 0;
        int curr = 0;
        for (int rung : rungs) {
            if (curr + dist < rung) {
                // 注意：这里需要-1
                // 例：(new int[]{4},2)，如果不-1，则会算出为2
                count += (rung - curr - 1) / dist;
            }
            curr = rung;
        }
        return count;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addRungs(new int[]{1, 3, 5, 10}, 2));// 2
        System.out.println(solution.addRungs(new int[]{3, 6, 8, 10}, 10));// 0
        System.out.println(solution.addRungs(new int[]{3, 4, 6, 7}, 2));// 1
        System.out.println(solution.addRungs(new int[]{5}, 10));// 0
        System.out.println(solution.addRungs(new int[]{3, 6, 8, 10}, 3));// 0
        System.out.println(solution.addRungs(new int[]{3}, 1)); // 2
        System.out.println(solution.addRungs(new int[]{4}, 1000000000)); // 0
    }
}