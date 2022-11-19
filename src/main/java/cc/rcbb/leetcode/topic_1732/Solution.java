package cc.rcbb.leetcode.topic_1732;

/**
 * 1732. 找到最高海拔
 * https://leetcode.cn/problems/find-the-highest-altitude/
 * <p>
 * 模拟
 */
class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int curr = 0;
        for (int i = 0; i < gain.length; i++) {
            curr = curr + gain[i];
            max = Math.max(max, curr);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestAltitude(new int[]{-5, 1, 5, 0, -7}));
        System.out.println(solution.largestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2}));
    }
}