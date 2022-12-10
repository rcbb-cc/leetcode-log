package cc.rcbb.leetcode.topic_1780;

/**
 * 1780. 判断一个数字是否可以表示成三的幂的和
 * https://leetcode.cn/problems/check-if-number-is-a-sum-of-powers-of-three/
 * <p>
 * 模拟、进制转换
 */
class Solution {

    /**
     * 将 n 转换成 3 进制
     * 如果 n 的 3 进制表示中每一位均不为 2，那么则为 true，否则为 false。
     *
     * @param n
     * @return
     */
    public boolean checkPowersOfThree(int n) {
        while (n != 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkPowersOfThree(12));
        System.out.println(solution.checkPowersOfThree(91));
        System.out.println(solution.checkPowersOfThree(21));
    }
}