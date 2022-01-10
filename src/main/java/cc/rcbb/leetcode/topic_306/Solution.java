package cc.rcbb.leetcode.topic_306;

/**
 * 306. 累加数
 * https://leetcode-cn.com/problems/additive-number/submissions/
 */
class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (f(i, j, num)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean f(int i, int j, String num) {
        int last = 0;
        int first = i;
        int second = j;
        int n = num.length();
        while (second < n) {
            if (num.charAt(last) == '0' && first > last + 1) {
                return false;
            }
            if (num.charAt(first) == '0' && second > first + 1) {
                return false;
            }
            String s = this.add(num.substring(last, first), num.substring(first, second));
            if (second + s.length() > n) {
                return false;
            }
            if (!s.equals(num.substring(second, second + s.length()))) {
                return false;
            }
            last = first;
            first = second;
            second += s.length();
        }
        return true;
    }

    private String add(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int one = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; ) {
            int curA = 0;
            int curB = 0;
            if (i >= 0) {
                curA = a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                curB = b.charAt(j) - '0';
                j--;
            }
            int cur = curA + curB + one;
            if (cur >= 10) {
                one = 1;
            } else {
                one = 0;
            }
            sb.append((char) ('0' + cur % 10));
        }
        if (one == 1) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        //输入："112358"
        //输出：true
        //解释：累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
        //System.out.println(solution.isAdditiveNumber("112358"));

        //输入："199100199"
        //输出：true
        //解释：累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
        System.out.println(solution.isAdditiveNumber("199100199"));
    }
}