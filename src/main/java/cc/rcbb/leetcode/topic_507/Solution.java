package cc.rcbb.leetcode.topic_507;

/**
 * 507. 完美数
 * https://leetcode-cn.com/problems/perfect-number/
 */
class Solution {
    public boolean checkPerfectNumber(int num) {
        int sum = 1;
        for (int i = 2; i <= num / i; i++) {
            if (num % i == 0) {
                sum += i;
                if (i != num / i) {
                    sum += num / i;
                }
            }
        }
        return num != 1 && num == sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkPerfectNumber(28));
        System.out.println(solution.checkPerfectNumber(6));
        System.out.println(solution.checkPerfectNumber(496));
        System.out.println(solution.checkPerfectNumber(8128));
        System.out.println(solution.checkPerfectNumber(2));
        System.out.println(solution.checkPerfectNumber(100000000));
    }
}