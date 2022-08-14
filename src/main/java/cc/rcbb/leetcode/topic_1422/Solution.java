package cc.rcbb.leetcode.topic_1422;

/**
 * 1422. 分割字符串的最大得分
 * https://leetcode.cn/problems/maximum-score-after-splitting-a-string/
 */
class Solution {
    public int maxScore(String s) {
        int max = 0;
        int n = s.length();
        if (s.charAt(0) == '0') {
            max++;
        }
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '1') {
                max++;
            }
        }
        int ans = max;
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == '0') {
                max++;
            } else {
                max--;
            }
            ans = Math.max(ans, max);
        }
        return ans;
    }

    public int maxScore1(String s) {
        int max = 0;
        int n = s.length();
        for (int i = 1; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == '0') {
                    sum++;
                }
            }
            for (int j = i; j < n; j++) {
                if (s.charAt(j) == '1') {
                    sum++;
                }
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxScore1("011101"));
        System.out.println(solution.maxScore1("00111"));
        System.out.println(solution.maxScore1("1111"));
        System.out.println(solution.maxScore1("00"));
    }

}