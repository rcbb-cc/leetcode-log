package cc.rcbb.leetcode.topic_2024;

/**
 * 2024. 考试的最大困扰度
 * https://leetcode-cn.com/problems/maximize-the-confusion-of-an-exam/
 */
class Solution {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(getMax(answerKey, k, 'T'), getMax(answerKey, k, 'F'));
    }

    private int getMax(String answerKey, int k, char c) {
        int max = 0;
        int left = 0;
        int right = 0;
        int n = answerKey.length();
        while (right < n) {
            char ra = answerKey.charAt(right);
            //不等于目标字符时，k--
            if (ra != c) {
                k--;
            }
            //当k小于0时，左边进行收缩
            if (k < 0) {
                char la = answerKey.charAt(left);
                left++;
                if (la != c) {
                    k++;
                }
            }
            //记录下当前窗口大小
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入：answerKey = "TTFF", k = 2
        //输出：4
        //解释：我们可以将两个 'F' 都变为 'T' ，得到 answerKey = "TTTT" 。
        //总共有四个连续的 'T' 。
        System.out.println(solution.maxConsecutiveAnswers("TTFF", 2));

        //输入：answerKey = "TFFT", k = 1
        //输出：3
        //解释：我们可以将最前面的 'T' 换成 'F' ，得到 answerKey = "FFFT" 。
        //或者，我们可以将第二个 'T' 换成 'F' ，得到 answerKey = "TFFF" 。
        //两种情况下，都有三个连续的 'F' 。
        System.out.println(solution.maxConsecutiveAnswers("TFFT", 1));

        //输入：answerKey = "TTFTTFTT", k = 1
        //输出：5
        //解释：我们可以将第一个 'F' 换成 'T' ，得到 answerKey = "TTTTTFTT" 。
        //或者我们可以将第二个 'F' 换成 'T' ，得到 answerKey = "TTFTTTTT" 。
        //两种情况下，都有五个连续的 'T' 。
        System.out.println(solution.maxConsecutiveAnswers("TTFTTFTT", 1));
    }
}