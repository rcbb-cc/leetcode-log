package cc.rcbb.leetcode.topic_526;

/**
 * 526. 优美的排列
 * https://leetcode.cn/problems/beautiful-arrangement/
 */
class Solution1 {

    public int countArrangement(int n) {
        int mask = 1 << n;
        int[][] f = new int[n + 1][mask];
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            // 枚举所有的状态
            for (int state = 0; state < mask; state++) {
                // 枚举位置 i 选的数值是 k
                for (int k = 1; k <= n; k++) {
                    // k 在 state 中必须是 1
                    if (((state >> (k - 1)) & 1) == 0) {
                        continue;
                    }
                    // 满足任一整除关系
                    if (k % i != 0 && i % k != 0) {
                        continue;
                    }
                    f[i][state] += f[i - 1][state & (~(1 << (k - 1)))];
                }
            }
        }
        return f[n][mask - 1];
    }


    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.countArrangement(2));
    }
}