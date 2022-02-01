package cc.rcbb.leetcode.topic_1342;

/**
 * 1342. 将数字变成 0 的操作次数
 * https://leetcode-cn.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 */
class Solution {
    public int numberOfSteps(int num) {
        int count = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                num--;
            } else {
                num = num >>> 1;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfSteps(14));
        System.out.println(solution.numberOfSteps(8));
        System.out.println(solution.numberOfSteps(123));

    }
}