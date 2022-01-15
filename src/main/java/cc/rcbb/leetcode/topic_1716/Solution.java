package cc.rcbb.leetcode.topic_1716;

/**
 * 1716. 计算力扣银行的钱
 * https://leetcode-cn.com/problems/calculate-money-in-leetcode-bank/
 */
class Solution {
    public int totalMoney(int n) {
        int sum = 0;
        // 多少周
        int weeks = n / 7;
        // 剩余天数
        int days = n % 7;
        // 第一周整周的钱
        int money = 28;
        // 每周一的钱
        int init = 1;

        for (int i = 0; i < weeks; i++) {
            sum += money;
            money += 7;
            init++;
        }

        for (int i = 0; i < days; i++) {
            sum += init;
            init++;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.totalMoney(4));
        System.out.println(solution.totalMoney(10));
        System.out.println(solution.totalMoney(20));
        // 135
        System.out.println(solution.totalMoney(26));
        System.out.println(solution.totalMoney(1000));

        /*int res = 0;
        for (int i = 0; i < 143; i++) {
            int sum = 0;
            for (int j = i + 1; j <= i + 7; j++) {
                System.out.print(j + " ");
                sum += j;
            }
            System.out.print(sum);
            res+=sum;
            System.out.println(" "+res);
        }*/
    }
}