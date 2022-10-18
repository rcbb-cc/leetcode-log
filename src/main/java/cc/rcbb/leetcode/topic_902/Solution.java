package cc.rcbb.leetcode.topic_902;

/**
 * 902. 最大为 N 的数字组合
 * https://leetcode.cn/problems/numbers-at-most-n-given-digit-set/
 * <p>
 * DFS
 */
class Solution {
    int count = 0;

    public int atMostNGivenDigitSet(String[] digits, int n) {
        char[] chars = new char[digits.length];
        int m = digits.length;
        for (int i = 0; i < m; i++) {
            chars[i] = digits[i].charAt(0);
        }
        dfs(chars, n, 0);
        return count;
    }

    public void dfs(char[] digits, int n, long t) {
        for (char digit : digits) {
            long temp = t * 10 + (digit - '0');
            if (temp > n) {
                break;
            }
            count++;
            dfs(digits, n, temp);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 输入：digits = ["1","3","5","7"], n = 100
        // 输出：20
        // 解释：
        // 可写出的 20 个数字是：
        // 1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
        System.out.println(solution.atMostNGivenDigitSet(new String[]{"1", "3", "5", "7"}, 100));
    }
}