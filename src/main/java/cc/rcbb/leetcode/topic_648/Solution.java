package cc.rcbb.leetcode.topic_648;

import java.util.*;

/**
 * 648. 单词替换
 * https://leetcode.cn/problems/replace-words/
 */
class Solution {
    public String replaceWords1(List<String> dictionary, String sentence) {
        Set<String> dictSet = new HashSet<>();
        for (String str : dictionary) {
            dictSet.add(str);
        }
        String[] senArray = sentence.split(" ");
        for (int i = 0; i < senArray.length; i++) {
            String word = senArray[i];
            for (int j = 0; j < word.length(); j++) {
                if (dictSet.contains(word.substring(0, j + 1))) {
                    senArray[i] = word.substring(0, j + 1);
                    break;
                }
            }
        }
        return String.join(" ", senArray);
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String word : dictionary) {
            Trie cur = trie;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                cur.children.putIfAbsent(c, new Trie());
                cur = cur.children.get(c);
            }
            cur.children.put('#', new Trie());
        }
        String[] senArray = sentence.split(" ");

        for (int i = 0; i < senArray.length; i++) {
            senArray[i] = findRoot(senArray[i], trie);
        }
        return String.join(" ", senArray);
    }

    public String findRoot(String word, Trie trie) {
        StringBuffer root = new StringBuffer();
        Trie cur = trie;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children.containsKey('#')) {
                return root.toString();
            }
            if (!cur.children.containsKey(c)) {
                return word;
            }
            root.append(c);
            cur = cur.children.get(c);
        }
        return root.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.replaceWords(List.of("cat", "bat", "rat"), "the cattle was rattled by the battery"));
    }

}

class Trie {
    Map<Character, Trie> children;

    public Trie() {
        children = new HashMap<>();
    }
}