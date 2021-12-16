package cc.rcbb.leetcode.template;

import cc.rcbb.leetcode.common.RcbbPrinter;

/**
 * <p>
 * BackpackTemplate
 * </p>
 *
 * @author lvhao
 * @date 2021/12/16
 */
public class BackpackTemplate {

    /**
     * 给你⼀个可装载重量为 W 的背包和 N 个物品，每个物品有重量和价值两个属性。
     * 其中第 i 个物品的重量为wt[i]，价值为 val[i]，
     * 现在让你⽤这个背包装物品，最多能装的价值是多少
     */
    public int backpack(int W, int N, int[] wt, int[] val) {
        // dp[i][j]的定义：对于前i个物品，当前背包容量为j时，可以装的最大价值是dp[i][j]
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                if (j - wt[i - 1] < 0) {
                    // 只能选择不装入背包
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 装入或不装入背包
                    dp[i][j] = Math.max(
                            dp[i - 1][j - wt[i - 1]] + val[i - 1],
                            dp[i - 1][j]
                    );
                }
            }
        }
        RcbbPrinter.print(dp);
        return dp[N][W];
    }

    public static void main(String[] args) {
        BackpackTemplate template = new BackpackTemplate();
        //int W = 4;
        //int N = 3;
        //int[] wt = new int[]{2, 1, 3};
        //int[] val = new int[]{4, 2, 3};

        int W = 4;
        int N = 3;
        int[] wt = new int[]{1, 2, 3};
        int[] val = new int[]{1, 2, 3};
        System.out.println(template.backpack(W, N, wt, val));
    }


}
