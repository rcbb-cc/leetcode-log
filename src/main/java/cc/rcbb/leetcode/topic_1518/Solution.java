package cc.rcbb.leetcode.topic_1518;

/**
 * 1518. 换酒问题
 * https://leetcode-cn.com/problems/water-bottles/
 */
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int count = numBottles;
        // 空瓶的数量
        int emptyBottles = numBottles;
        // 当空瓶的数量还大于或等于可兑换的数量时
        while (emptyBottles >= numExchange) {
            // 进行兑换
            int temp = emptyBottles / numExchange;
            count += temp;
            emptyBottles = emptyBottles % numExchange + temp;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numWaterBottles(9, 3));
        System.out.println(solution.numWaterBottles(15, 4));
        System.out.println(solution.numWaterBottles(5, 5));
        System.out.println(solution.numWaterBottles(2, 3));
        System.out.println(solution.numWaterBottles(15, 8));
    }
}