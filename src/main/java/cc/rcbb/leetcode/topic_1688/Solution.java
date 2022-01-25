package cc.rcbb.leetcode.topic_1688;

/**
 * 1688. 比赛中的配对次数
 * https://leetcode-cn.com/problems/count-of-matches-in-tournament/
 */
class Solution {
    public int numberOfMatches(int n) {
        return n - 1;
    }

    public int numberOfMatches1(int n) {
        int count = 0;
        while (n != 1) {
            if ((n & 1) == 1) {
                n = (n - 1) / 2;
                count += n;
                n = n + 1;
            } else {
                n /= 2;
                count += n;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfMatches(7));
        System.out.println(solution.numberOfMatches(14));
        System.out.println(solution.numberOfMatches(200));
    }
}