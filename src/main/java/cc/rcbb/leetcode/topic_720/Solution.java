package cc.rcbb.leetcode.topic_720;

import java.util.*;

/**
 * 720. 词典中最长的单词
 * https://leetcode-cn.com/problems/longest-word-in-dictionary/
 */
class Solution {

    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> {
            if (a.length() != b.length()) {
                //首先按照单词的长度升序排序
                return a.length() - b.length();
            } else {
                //如果单词的长度相同则按照字典序降序排序，将长度相同的字典序小的放到后面
                return b.compareTo(a);
            }
        });
        Set<String> set = new HashSet<>();
        set.add("");
        String result = "";
        for (String w : words) {
            //判断当前单词去掉最后一个字母之后的前缀是否在哈希集合中
            if (set.contains(w.substring(0, w.length() - 1))) {
                set.add(w);
                result = w;
            }
        }
        return result;
    }

    public String longestWord1(String[] words) {
        Arrays.sort(words);
        Set<String> set = new HashSet<>();
        for (String w : words) {
            set.add(w);
        }
        String result = "";
        for (String w : words) {
            boolean flag = true;
            for (int i = 1; i < w.length(); i++) {
                if (!set.contains(w.substring(0, w.length() - i))) {
                    flag = false;
                }
            }
            if (flag && w.length() > result.length()) {
                result = w;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestWord(new String[]{"w", "wo", "wor", "worl", "world"}));
        System.out.println(solution.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
        System.out.println(solution.longestWord(new String[]{"yo", "ew", "fc", "zrc", "yodn", "fcm", "qm", "qmo", "fcmz", "z", "ewq", "yod", "ewqz", "y"}));
    }
}