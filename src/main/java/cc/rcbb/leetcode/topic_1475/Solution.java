package cc.rcbb.leetcode.topic_1475;

import cc.rcbb.leetcode.common.RcbbPrinter;

/**
 * 1475. 商品折扣后的最终价格
 * https://leetcode.cn/problems/final-prices-with-a-special-discount-in-a-shop/
 */
class Solution {
    /**
     * 其中 j 是满足 j > i 且 prices[j] <= prices[i] 的 最小下标 ，如果没有满足条件的 j ，你将没有任何折扣。
     *
     * @param prices
     * @return
     */
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (prices[i] >= prices[j]) {
                    prices[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return prices;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 输入：prices = [8,4,6,2,3]
        // 输出：[4,2,4,2,3]
        RcbbPrinter.print(solution.finalPrices(new int[]{8, 4, 6, 2, 3}));
        // 输入：prices = [1,2,3,4,5]
        // 输出：[1,2,3,4,5]
        RcbbPrinter.print(solution.finalPrices(new int[]{1, 2, 3, 4, 5}));
        // 输入：prices = [10,1,1,6]
        // 输出：[9,0,1,6]
        RcbbPrinter.print(solution.finalPrices(new int[]{10, 1, 1, 6}));
    }
}