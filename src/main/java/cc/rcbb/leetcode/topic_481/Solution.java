package cc.rcbb.leetcode.topic_481;

/**
 * 481. 神奇字符串
 * https://leetcode.cn/problems/magical-string/
 * <p>
 * 模拟
 */
class Solution {
    public int magicalString(int n) {
        if (n < 4) {
            return 1;
        }
        char[] s = new char[n];
        s[0] = '1';
        s[1] = '2';
        s[2] = '2';
        int res = 1;
        int i = 2;
        int j = 3;
        while (j < n) {
            int size = s[i] - '0';
            // 通过 j 的前一个位置的数来判断当前需要填入的组中的数字
            int num = 3 - (s[j - 1] - '0');
            while (size > 0 && j < n) {
                s[j] = (char) ('0' + num);
                if (num == 1) {
                    res++;
                }
                j++;
                size--;
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.magicalString(6));
    }
}