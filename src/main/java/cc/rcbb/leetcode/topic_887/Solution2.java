package cc.rcbb.leetcode.topic_887;

/**
 * 887. 鸡蛋掉落
 * https://leetcode-cn.com/problems/super-egg-drop/
 */
class Solution2 {

    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];
        int m = 0;
        while (dp[k][m] < n) {
            m++;
            for (int i = 1; i <= k; i++) {
                dp[i][m] = dp[i][m - 1] + dp[i - 1][m - 1] + 1;
            }
        }
        return m;
    }

    public int superEggDrop1(int k, int n) {

        /**
         * dp[k][m]=n，当前有k个鸡蛋，可以尝试扔m次。
         * 这个状态下，最坏的情况下最多能确切测试n层。
         *
         * 例：dp[1][7]=7
         * 现在有1个鸡蛋，允许你扔7次，这个状态下最多给你7层楼，让你确认哪个楼层使鸡蛋恰好不碎。
         *
         *
         * 题意：给你k个鸡蛋，n层楼，求最坏情况下最少的测试次数m。
         *
         * 改造：给你k个鸡蛋，允许你测试m次，最坏情况下最多能测试n层楼。
         */
        int[][] dp = new int[k + 1][n + 1];
        int m = 0;
        while (dp[k][m] < n) {
            System.out.println("dp[" + k + "][" + m + "] < " + n + "  (" + dp[k][m] + " < " + n + ")");
            m++;
            System.out.println("m=" + m);
            for (int i = 1; i <= k; i++) {
                System.out.println("dp[" + i + "][" + (m-1) + "] = dp[" + i + "][" + (m - 1) + "](" + dp[i][m - 1] + ") + dp[" + (i - 1) + "][" + (m - 1) + "](" + dp[i - 1][m - 1] + ") + 1   =" + (dp[i][m - 1] + dp[i - 1][m - 1] + 1));
                // 为什么m是减一？因为m是允许次数的上界，而不是扔了几次。
                dp[i][m] = dp[i][m - 1] + dp[i - 1][m - 1] + 1;
            }
        }
        return m;
    }


    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.superEggDrop(1, 2));
        System.out.println(solution.superEggDrop(2, 6));
        System.out.println(solution.superEggDrop(3, 14));
        System.out.println(solution.superEggDrop(6, 10000));
    }

}