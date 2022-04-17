package cc.rcbb.leetcode.topic_819;

import java.util.*;

/**
 * 819. 最常见的单词
 * https://leetcode-cn.com/problems/most-common-word/
 */
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        for (String s : banned) {
            bannedSet.add(s);
        }
        int max = 0;
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= paragraph.length(); i++) {
            if (i < paragraph.length() && Character.isLetter(paragraph.charAt(i))) {
                sb.append(Character.toLowerCase(paragraph.charAt(i)));
            } else if (sb.length() > 0) {
                String key = sb.toString();
                if (!bannedSet.contains(key)) {
                    int count = map.getOrDefault(key, 0) + 1;
                    map.put(key, count);
                    max = Math.max(max, count);
                }
                sb.setLength(0);
            }
        }
        String res = "";
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            if (next.getValue() == max) {
                res = next.getKey();
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
        System.out.println(solution.mostCommonWord("a, a, a, a, b,b,b,c, c", new String[]{"a"}));
        System.out.println(solution.mostCommonWord("Bob", new String[]{}));
    }

}