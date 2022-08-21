package cc.rcbb.leetcode.topic_1455;

/**
 * 1455. 检查单词是否为句中其他单词的前缀
 * https://leetcode.cn/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
 */
class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int index = -1;
        String[] strArray = sentence.split(" ");
        for (int i = 0; i < strArray.length; i++) {
            if (isPrefix(strArray[i], searchWord)) {
                index = i + 1;
                break;
            }
        }
        return index;
    }

    public boolean isPrefix(String sentence, String searchWord) {
        for (int i = 0; i < searchWord.length(); i++) {
            if (i >= sentence.length()) {
                return false;
            }
            if (sentence.charAt(i) != searchWord.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isPrefixOfWord("hello from the other side", "they"));
        System.out.println(solution.isPrefixOfWord("i love eating burger", "burg"));
        System.out.println(solution.isPrefixOfWord("this problem is an easy problem", "pro"));
        System.out.println(solution.isPrefixOfWord("i am tired", "you"));
        System.out.println(solution.isPrefixOfWord("hellohello hellohellohello", "ell"));


    }

}