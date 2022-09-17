package cc.rcbb.leetcode.topic_1624;

/**
 * 1624. 两个相同字符之间的最长子字符串
 * https://leetcode.cn/problems/largest-substring-between-two-equal-characters/
 */
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int n = s.length();
        char[] array = s.toCharArray();
        int max = 0;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                if (array[i] == array[j]) {
                    max = Math.max(max, j - i - 1);
                    flag = false;
                    break;
                }
            }
        }
        return flag ? -1 : max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxLengthBetweenEqualCharacters("aa"));
        System.out.println(solution.maxLengthBetweenEqualCharacters("abca"));
        System.out.println(solution.maxLengthBetweenEqualCharacters("cbzxy"));
        System.out.println(solution.maxLengthBetweenEqualCharacters("cabbac"));
    }

}