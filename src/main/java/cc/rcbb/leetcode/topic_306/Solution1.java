package cc.rcbb.leetcode.topic_306;

/**
 * 306. 累加数
 * https://leetcode-cn.com/problems/additive-number/submissions/
 */
class Solution1 {
    public boolean isAdditiveNumber(String num) {
        return f(num, 0, 0, 0, 0);
    }

    private boolean f(String num, int index, int count, long prevprev, long prev) {
        if (index >= num.length()) {
            return count > 2;
        }
        long current = 0;
        for (int i = index; i < num.length(); i++) {
            char c = num.charAt(i);
            if (num.charAt(index) == '0' && i > index) {
                return false;
            }
            current = current * 10 + (c - '0');
            if (count >= 2) {
                long sum = prevprev + prev;
                if (current > sum) {
                    return false;
                }
                if (current < sum) {
                    continue;
                }
            }
            if (f(num, i + 1, count + 1, prev, current)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        //输入："112358"
        //输出：true
        //解释：累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
        System.out.println(solution.isAdditiveNumber("112358"));
        //输入："199100199"
        //输出：true
        //解释：累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
        System.out.println(solution.isAdditiveNumber("199100199"));
    }
}