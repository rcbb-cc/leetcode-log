package cc.rcbb.leetcode.topic_884;

import cc.rcbb.leetcode.common.RcbbPrinter;

import java.util.*;

/**
 * 884. 两句话中的不常见单词
 * https://leetcode-cn.com/problems/uncommon-words-from-two-sentences/
 */
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String s : s1.split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : s2.split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() == 1) {
                result.add(e.getKey());
            }
        }
        return result.toArray(new String[result.size()]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        RcbbPrinter.print(solution.uncommonFromSentences("this apple is sweet", "this apple is sour"));
        RcbbPrinter.print(solution.uncommonFromSentences("apple apple", "banana"));
    }
}