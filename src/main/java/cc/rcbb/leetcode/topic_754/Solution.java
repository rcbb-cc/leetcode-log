package cc.rcbb.leetcode.topic_754;

/**
 * 754. 到达终点数字
 * https://leetcode.cn/problems/reach-a-number/
 * <p>
 * 模拟、数学
 */
class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int k = 0;
        while (target > 0) {
            k++;
            target -= k;
        }
        return target % 2 == 0 ? k : k + 1 + k % 2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reachNumber(2));
        System.out.println(solution.reachNumber(3));
    }
}