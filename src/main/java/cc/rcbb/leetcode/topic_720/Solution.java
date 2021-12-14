package cc.rcbb.leetcode.topic_720;

import java.util.*;

/**
 * 720. 词典中最长的单词
 * https://leetcode-cn.com/problems/longest-word-in-dictionary/
 */
class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> wordSet = new HashSet<>();
        for (String word : words) {
            wordSet.add(word);
        }
        int max = 0;
        String result = "";
        for (String word : words) {
            boolean flag = true;
            for (int i = 1; i < word.length(); i++) {
                String tempWork = word.substring(0, word.length() - i);
                if (!wordSet.contains(tempWork)) {
                    flag = false;
                }
            }
            if (flag) {
                if (word.length() > max) {
                    max = word.length();
                    result = word;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestWord(new String[]{"w", "wo", "wor", "worl", "world"}));
        System.out.println(solution.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
    }
}