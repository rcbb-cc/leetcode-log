package cc.rcbb.leetcode.topic_2000;

/**
 * 2000. 反转单词前缀
 * https://leetcode-cn.com/problems/reverse-prefix-of-word/
 */
class Solution {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if (index == -1) {
            return word;
        }
        StringBuilder sb = new StringBuilder(word.substring(0, index + 1));
        return sb.reverse().append(word.substring(index + 1)).toString();
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        // 输入：word = "abcdefd", ch = "d"
        // 输出："dcbaefd"
        System.out.println(solution.reversePrefix("abcdefd", 'd'));
        // 输入：word = "xyxzxe", ch = "z"
        // 输出："zxyxxe"
        System.out.println(solution.reversePrefix("xyxzxe", 'z'));
        // 输入：word = "abcd", ch = "z"
        // 输出："abcd"
        System.out.println(solution.reversePrefix("abcd", 'z'));
    }
}